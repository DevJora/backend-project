package org.pro.optis.backend.bo.response;

import java.util.List;

public class Optima6Response {
    private List<List<Integer>> transportPlan;
    private int totalCost;

    public Optima6Response(List<List<Integer>> transportPlan, int totalCost) {
        this.transportPlan = transportPlan;
        this.totalCost = totalCost;
    }

    public List<List<Integer>> getTransportPlan() {
        return transportPlan;
    }

    public void setTransportPlan(List<List<Integer>> transportPlan) {
        this.transportPlan = transportPlan;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
