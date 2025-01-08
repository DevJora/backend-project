package org.pro.optis.backend.bo.response;

import java.util.List;

public class Optima4Response {
        private int optimalStock;
        private double totalStorageCost;
        private int backlogUnits;
        private double backlogCost;

        public Optima4Response(int optimalStock, double totalStorageCost, int backlogUnits, double backlogCost) {
            this.optimalStock = optimalStock;
            this.totalStorageCost = totalStorageCost;
            this.backlogUnits = backlogUnits;
            this.backlogCost = backlogCost;
        }

    public int getOptimalStock() {
        return optimalStock;
    }

    public void setOptimalStock(int optimalStock) {
        this.optimalStock = optimalStock;
    }

    public double getTotalStorageCost() {
        return totalStorageCost;
    }

    public void setTotalStorageCost(double totalStorageCost) {
        this.totalStorageCost = totalStorageCost;
    }

    public int getBacklogUnits() {
        return backlogUnits;
    }

    public void setBacklogUnits(int backlogUnits) {
        this.backlogUnits = backlogUnits;
    }

    public double getBacklogCost() {
        return backlogCost;
    }

    public void setBacklogCost(double backlogCost) {
        this.backlogCost = backlogCost;
    }

    // Getters et Setters
    }
