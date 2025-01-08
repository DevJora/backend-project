package org.pro.optis.backend.bo;

public class OptimaXRequest {
    private double storageCost;  // Coût de stockage par unité (C1)
    private double shortageCost; // Coût de rupture par unité (C2)
    private double discountFactor; // Facteur d'actualisation (v)
    private int currentStock;  // Stock actuel
    private int demandMean;  // Demande moyenne
    private int maxOrder;  // Commande maximale

    // Getters et Setters
    public double getStorageCost() {
        return storageCost;
    }
    public void setStorageCost(double storageCost) {
        this.storageCost = storageCost;
    }
    public double getShortageCost() {
        return shortageCost;
    }
    public void setShortageCost(double shortageCost) {
        this.shortageCost = shortageCost;
    }
    public double getDiscountFactor() {
        return discountFactor;
    }
    public void setDiscountFactor(double discountFactor) {
        this.discountFactor = discountFactor;
    }
    public int getCurrentStock() {
        return currentStock;
    }
    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }
    public int getDemandMean() {
        return demandMean;
    }
    public void setDemandMean(int demandMean) {
        this.demandMean = demandMean;
    }
    public int getMaxOrder() {
        return maxOrder;
    }
    public void setMaxOrder(int maxOrder) {
        this.maxOrder = maxOrder;
    }
}
