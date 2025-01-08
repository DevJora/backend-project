package org.pro.optis.backend.bo;

import java.util.List;

public class Optima7Response {
    private List<Integer> optimalSequence;
    private int totalProcessingTime;

    public Optima7Response(List<Integer> optimalSequence, int totalProcessingTime) {
        this.optimalSequence = optimalSequence;
        this.totalProcessingTime = totalProcessingTime;
    }

    public List<Integer> getOptimalSequence() {
        return optimalSequence;
    }

    public int getTotalProcessingTime() {
        return totalProcessingTime;
    }
}
