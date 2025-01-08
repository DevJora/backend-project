package org.pro.optis.backend.bo.response;


public class Optima3Response {
    private String productName;
    private double cost;
    private String decision;

    public Optima3Response(String productName, double cost, String decision) {
        this.productName = productName;
        this.cost = cost;
        this.decision = decision;
    }

    public String getProductName() {
        return productName;
    }

    public double getCost() {
        return cost;
    }

    public String getDecision() {
        return decision;
    }
}

