package org.pro.optis.backend.bo;

public class Optima1Request {
    private double demand;
    private double productionCost;
    private double storageCost;
    private double dailyProductionCapacity;
    private double capacity;
    private String timeUnit;

    // Getters and Setters
    public double getDemand() {
        return demand;
    }

    public void setDemand(double demand) {
        this.demand = demand;
    }

    public double getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(double productionCost) {
        this.productionCost = productionCost;
    }

    public double getStorageCost() {
        return storageCost;
    }

    public void setStorageCost(double storageCost) {
        this.storageCost = storageCost;
    }

    public double getDailyProductionCapacity() {
        return dailyProductionCapacity;
    }

    public void setDailyProductionCapacity(double dailyProductionCapacity) {
        this.dailyProductionCapacity = dailyProductionCapacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }
}
