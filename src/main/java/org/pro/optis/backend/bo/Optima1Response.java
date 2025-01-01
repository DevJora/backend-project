package org.pro.optis.backend.bo;

public class Optima1Response {
    private double optimalCycleFrequency;
    private double optimalCycleInterval;

    public Optima1Response(double optimalCycleFrequency, double optimalCycleInterval) {
        this.optimalCycleFrequency = optimalCycleFrequency;
        this.optimalCycleInterval = optimalCycleInterval;
    }

    public double getOptimalCycleInterval() {
        return optimalCycleInterval;
    }

    public void setOptimalCycleInterval(double optimalCycleInterval) {
        this.optimalCycleInterval = optimalCycleInterval;
    }

    public double getOptimalCycleFrequency() {
        return optimalCycleFrequency;
    }

    public void setOptimalCycleFrequency(double optimalCycleFrequency) {
        this.optimalCycleFrequency = optimalCycleFrequency;
    }
}

