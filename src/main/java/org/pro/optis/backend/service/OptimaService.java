package org.pro.optis.backend.service;

import org.pro.optis.backend.bo.*;
import org.pro.optis.backend.bo.request.*;
import org.pro.optis.backend.bo.response.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OptimaService {
    public Optima1Response calculateOptimum1(Optima1Request request) {
        // Algorithme de calcul de la fréquence optimale de production
        double demand = request.getDemand();
        double productionCost = request.getProductionCost();
        double storageCost = request.getStorageCost();
        double productionCapacity = request.getDailyProductionCapacity();
        String timeUnit = request.getTimeUnit();  // jour, semaine, mois

        // Conversion des unités de temps
        double conversionFactor = switch (timeUnit.toLowerCase()) {
            case "semaine" -> 7;
            case "mois" -> 30;
            default -> 1;  // Par défaut en jours
        };

        // Adapter la capacité de production seulement si l'unité n'est pas en jours
        double adjustedCapacity = productionCapacity * conversionFactor;
        double adjustedDemand = demand * conversionFactor;
        double adjustedStorageCost = storageCost / conversionFactor;  // Ajustement du coût de stockage

        double denominator = (1 - (adjustedDemand / adjustedCapacity));
        if (denominator <= 0) {
            denominator = 0.01;  // Éviter la division par zéro
        }

        double optimalCycleFrequency = Math.sqrt((2 * productionCost * adjustedDemand)/(adjustedStorageCost * denominator));
        double optimalCycleInterval = Math.sqrt((2 * productionCost) / (adjustedStorageCost  * (1 - (adjustedDemand / adjustedCapacity))));

        return new Optima1Response(optimalCycleFrequency, optimalCycleInterval);
    }

    public Optima2Response calculateOptimum2(Optima2Request request) {
        int[] demandData = request.getDemandData();
        double storageCost = request.getStorageCost();
        double orderCost = request.getOrderCost();
        double shortageCost = request.getShortageCost();

        int totalDays = demandData.length;

        // Calcul de la distribution de probabilité
        Map<Integer, Double> probabilityDistribution = new HashMap<>();
        for (int demand : demandData) {
            probabilityDistribution.put(demand,
                    probabilityDistribution.getOrDefault(demand, 0.0) + 1);
        }

        // Calcul des probabilités
        for (Map.Entry<Integer, Double> entry : probabilityDistribution.entrySet()) {
            probabilityDistribution.put(entry.getKey(), entry.getValue() / totalDays);
        }

        // Calcul du coût total pour chaque niveau de stock (z)
        double optimalStockLevel = 0;
        double minimalCost = Double.MAX_VALUE;

        for (int z = 0; z <= demandData.length; z++) {
            double totalCost = calculateTotalCost(z, probabilityDistribution, storageCost, orderCost, shortageCost);

            if (totalCost < minimalCost) {
                minimalCost = totalCost;
                optimalStockLevel = z;
            }
        }

        double optimalCycleFrequency = calculateCycleFrequency(probabilityDistribution);

        return new Optima2Response(optimalStockLevel, optimalCycleFrequency, minimalCost);
    }
    private double calculateStockLevel(Map<Integer, Double> distribution) {
        return distribution.entrySet().stream()
                .mapToDouble(entry -> entry.getKey() * entry.getValue())
                .sum();
    }
    private double calculateTotalCost(int z, Map<Integer, Double> distribution,
                                      double storageCost, double orderCost, double shortageCost) {
        double cost = 0.0;

        for (Map.Entry<Integer, Double> entry : distribution.entrySet()) {
            int demand = entry.getKey();
            double probability = entry.getValue();

            if (demand > z) {
                // Pénalité pour rupture de stock
                cost += (demand - z) * shortageCost * probability;
            } else {
                // Coût de stockage
                cost += (z - demand) * storageCost * probability;
            }
        }

        // Ajout du coût de commande
        cost += orderCost;

        return cost;
    }

    private double calculateCycleFrequency(Map<Integer, Double> distribution) {
        return 1.0 / distribution.values().stream().mapToDouble(prob -> prob).sum();
    }

    public List<Optima3Response> calculateOptimum3(Optima3Request request) {
        List<Optima3Response> results = new ArrayList<>();

        double preparationCost = request.getPreparationCost();  // Utilisation du coût envoyé
        double threshold = calculateThreshold(request.getProducts());  // Calcul dynamique

        double totalCost = preparationCost;
        for (Optima3Request product : request.getProducts()) {
            double cost = product.getStock() * product.getStorageCost() + product.getShortageCost();
            totalCost += cost;

            boolean productionRequired = totalCost >= threshold;

            results.add(new Optima3Response(
                    product.getProductName(),
                    cost,
                    productionRequired ? "Production nécessaire" : "Production reportée"
            ));
        }
        return results;
    }

    // Calcul dynamique du seuil
    private double calculateThreshold(List<Optima3Request> requests) {
        return requests.stream()
                .mapToDouble(req -> req.getStock() * req.getStorageCost() + req.getShortageCost())
                .sum();
    }

    public Optima4Response calculateOptimum4(Optima4Request request) {
        int Q = request.getInitialStock();
        int demand = request.getDemand();
        double cs = request.getStorageCost();
        double pi = request.getFixedStorageCost();
        double beta = request.getBacklogCost();
        double epsilon = request.getDelayPenalty();

        int Q_star = Q;  // Stock optimal
        int backlog = 0;
        double totalCost;

        if (Q < demand) {
            backlog = demand - Q;
            Q_star = demand;
        }

        totalCost = pi + (Q_star * cs) + (backlog * beta) + (backlog * epsilon);

        return new Optima4Response(Q_star, totalCost, backlog, backlog * beta);
    }

    public Optima5Response calculateOptimum5(Optima5Request request) {
        List<Integer> demand = request.getDemandForecast();
        int stock = request.getInitialStock();
        int capacity = request.getProductionCapacity();
        int upCost = request.getAdjustmentUpCost();
        int downCost = request.getAdjustmentDownCost();
        int maxStorage = request.getMaxStorage();

        List<Integer> productionPlan = new ArrayList<>();
        int totalCost = 0;
        int previousProduction = stock;

        for (int monthlyDemand : demand) {
            int production = Math.min(capacity, monthlyDemand);

            if (production > previousProduction) {
                totalCost += (production - previousProduction) * upCost;
            } else {
                totalCost += (previousProduction - production) * downCost;
            }

            stock += production - monthlyDemand;
            if (stock > maxStorage) {
                stock = maxStorage;  // Éviter de dépasser la capacité
            }

            productionPlan.add(production);
            previousProduction = production;
        }

        return new Optima5Response(productionPlan, totalCost);
    }

    public Optima6Response calculateOptimum6(Optima6Request request) {
        List<Integer> demand = request.getDemand();
        List<Integer> production = request.getProduction();
        List<List<Integer>> transportCost = request.getTransportCost();

        int totalCost = 0;
        List<List<Integer>> transportPlan = new ArrayList<>();

        for (int i = 0; i < production.size(); i++) {
            transportPlan.add(new ArrayList<>());
            for (int j = 0; j < demand.size(); j++) {
                transportPlan.get(i).add(0);
            }
        }

        for (int i = 0; i < production.size(); i++) {
            for (int j = 0; j < demand.size(); j++) {
                int quantity = Math.min(production.get(i), demand.get(j));
                production.set(i, production.get(i) - quantity);
                demand.set(j, demand.get(j) - quantity);
                transportPlan.get(i).set(j, quantity);
                totalCost += quantity * transportCost.get(i).get(j);
            }
        }

        return new Optima6Response(transportPlan, totalCost);
    }


    // Fonction de coût actualisée
    private double calculateCost(int S, int s, double C1, double C2, int demand, double v) {
        double I = C1 * Math.max(0, S - demand) + C2 * Math.max(0, demand - S);
        return I + v * I;
    }

    public Optima7Response calculateOptimum7(Optima7Request request) {
        List<List<Integer>> processTimes = request.getProcessTimes();
        int n = processTimes.size(); // Nombre de pièces
        List<Integer> sequence = new ArrayList<>();
        List<Integer> jobIndices = new ArrayList<>();

        // Initialisation des indices
        for (int i = 0; i < n; i++) {
            jobIndices.add(i);
        }

        // Tri des indices en fonction du temps minimum
        Collections.sort(jobIndices, (a, b) -> {
            int minTimeA = Collections.min(processTimes.get(a));
            int minTimeB = Collections.min(processTimes.get(b));
            return Integer.compare(minTimeA, minTimeB);
        });

        sequence.addAll(jobIndices);
        int totalProcessingTime = calculateTotalTime(sequence, processTimes);

        return new Optima7Response(sequence, totalProcessingTime);
    }

    // Calcul du temps total en fonction de la séquence
    private int calculateTotalTime(List<Integer> sequence, List<List<Integer>> processTimes) {
        int total = 0;
        for (Integer job : sequence) {
            total += processTimes.get(job).stream().mapToInt(Integer::intValue).sum();
        }
        return total;
    }

    public Optima8Response calculateOptimum8(Optima8Request request) {
        List<List<String>> data = request.getMarketData();
        Map<String, Integer> segmentCounts = new HashMap<>();

        // Segmentation basée sur les critères (ex: âge, classe sociale, zone)
        for (List<String> record : data) {
            String segmentKey = String.join("-", record);  // Ex: 18-24-Supérieure-Centre
            segmentCounts.put(segmentKey, segmentCounts.getOrDefault(segmentKey, 0) + 1);
        }

        return new Optima8Response(segmentCounts);
    }

    public Optima9Response calculateOptimum9(Optima9Request request) {
        List<List<String>> data = request.getMarketData();
        Map<String, Integer> segmentCounts = new HashMap<>();

        // Segmentation basée sur les critères (ex: âge, classe sociale, zone)
        for (List<String> record : data) {
            String segmentKey = String.join("-", record);  // Ex: 18-24-Supérieure-Centre
            segmentCounts.put(segmentKey, segmentCounts.getOrDefault(segmentKey, 0) + 1);
        }

        return new Optima9Response(segmentCounts);

    }

    public OptimaXResponse calculateOptimumX(OptimaXRequest request) {
        double v = request.getDiscountFactor();
        double C1 = request.getStorageCost();
        double C2 = request.getShortageCost();
        int s = request.getCurrentStock();
        int maxOrder = request.getMaxOrder();
        int demand = request.getDemandMean();

        double minCost = Double.MAX_VALUE;
        int optimalOrder = 0;

        for (int S = s; S <= maxOrder; S++) {
            double cost = calculateCost(S, s, C1, C2, demand, v);
            if (cost < minCost) {
                minCost = cost;
                optimalOrder = S;
            }
        }

        return new OptimaXResponse(optimalOrder, minCost);
    }


}
