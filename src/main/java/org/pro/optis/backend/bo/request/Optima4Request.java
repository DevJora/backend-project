package org.pro.optis.backend.bo.request;

public class Optima4Request {
        private int initialStock;
        private double storageCost;
        private double fixedStorageCost;
        private double backlogCost;
        private double delayPenalty;
        private int demand;

        // Getters et Setters

    public int getInitialStock() {
        return initialStock;
    }

    public void setInitialStock(int initialStock) {
        this.initialStock = initialStock;
    }

    public double getStorageCost() {
        return storageCost;
    }

    public void setStorageCost(double storageCost) {
        this.storageCost = storageCost;
    }

    public double getFixedStorageCost() {
        return fixedStorageCost;
    }

    public void setFixedStorageCost(double fixedStorageCost) {
        this.fixedStorageCost = fixedStorageCost;
    }

    public double getBacklogCost() {
        return backlogCost;
    }

    public void setBacklogCost(double backlogCost) {
        this.backlogCost = backlogCost;
    }

    public double getDelayPenalty() {
        return delayPenalty;
    }

    public void setDelayPenalty(double delayPenalty) {
        this.delayPenalty = delayPenalty;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }
}


