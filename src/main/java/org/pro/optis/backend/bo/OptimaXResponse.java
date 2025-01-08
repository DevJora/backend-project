package org.pro.optis.backend.bo;

public class OptimaXResponse {
    private int optimalOrder;  // Quantité optimale à commander
    private double longTermCost;  // Coût moyen à long terme

    public OptimaXResponse(int optimalOrder, double longTermCost) {
        this.optimalOrder = optimalOrder;
        this.longTermCost = longTermCost;
    }

    public int getOptimalOrder() {
        return optimalOrder;
    }
    public double getLongTermCost() {
        return longTermCost;
    }
}
