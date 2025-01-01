package org.pro.optis.backend.bo;

public class Optima2Response {

    private double optimalStockLevel;
    private double optimalCycleFrequency;
    private double minimalCost;

    public Optima2Response(double stockLevel, double frequency, double cost) {
        this.optimalStockLevel = stockLevel;
        this.optimalCycleFrequency = frequency;
        this.minimalCost = cost;
    }

    public double getMinimalCost() {
        return minimalCost;
    }

    public double getOptimalStockLevel() {
        return optimalStockLevel;
    }

    public double getOptimalCycleFrequency() {
        return optimalCycleFrequency;
    }
}
