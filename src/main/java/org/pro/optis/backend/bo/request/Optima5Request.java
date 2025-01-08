package org.pro.optis.backend.bo.request;

import java.util.List;

public class Optima5Request {
    private List<Integer> demandForecast;
    private int initialStock;
    private int productionCapacity;
    private int adjustmentUpCost;
    private int adjustmentDownCost;
    private int maxStorage;

    public List<Integer> getDemandForecast() {
        return demandForecast;
    }

    public void setDemandForecast(List<Integer> demandForecast) {
        this.demandForecast = demandForecast;
    }

    public int getInitialStock() {
        return initialStock;
    }

    public void setInitialStock(int initialStock) {
        this.initialStock = initialStock;
    }

    public int getProductionCapacity() {
        return productionCapacity;
    }

    public void setProductionCapacity(int productionCapacity) {
        this.productionCapacity = productionCapacity;
    }

    public int getAdjustmentUpCost() {
        return adjustmentUpCost;
    }

    public void setAdjustmentUpCost(int adjustmentUpCost) {
        this.adjustmentUpCost = adjustmentUpCost;
    }

    public int getAdjustmentDownCost() {
        return adjustmentDownCost;
    }

    public void setAdjustmentDownCost(int adjustmentDownCost) {
        this.adjustmentDownCost = adjustmentDownCost;
    }

    public int getMaxStorage() {
        return maxStorage;
    }

    public void setMaxStorage(int maxStorage) {
        this.maxStorage = maxStorage;
    }
}
