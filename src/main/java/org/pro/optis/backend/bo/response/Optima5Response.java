package org.pro.optis.backend.bo.response;

import java.util.List;

public class Optima5Response {
    private List<Integer> productionPlan;
    private int totalCost;

    public Optima5Response(List<Integer> productionPlan, int totalCost) {
        this.productionPlan = productionPlan;
        this.totalCost = totalCost;
    }

    public List<Integer> getProductionPlan() {
        return productionPlan;
    }

    public void setProductionPlan(List<Integer> productionPlan) {
        this.productionPlan = productionPlan;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
