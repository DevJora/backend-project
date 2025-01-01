package org.pro.optis.backend.service;

import org.pro.optis.backend.bo.Optima1Request;
import org.pro.optis.backend.bo.Optima1Response;
import org.pro.optis.backend.bo.Optima2Request;
import org.pro.optis.backend.bo.Optima2Response;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
}
