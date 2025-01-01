package org.pro.optis.backend.bo;

public class Optima2Request {
    private int[] demandData;
    private double storageCost;
    private double orderCost;
    private double shortageCost;

    public int[] getDemandData() {
        return demandData;
    }

    public void setDemandData(int[] demandData) {
        this.demandData = demandData;
    }

    public double getStorageCost() {
        return storageCost;
    }

    public void setStorageCost(double storageCost) {
        this.storageCost = storageCost;
    }

    public double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(double orderCost) {
        this.orderCost = orderCost;
    }

    public double getShortageCost() {
        return shortageCost;
    }

    public void setShortageCost(double shortageCost) {
        this.shortageCost = shortageCost;
    }
}
