package org.pro.optis.backend.bo;

import java.util.List;

public class Optima8Request {
    private List<List<String>> marketData;  // Données d'échantillon (âge, classe, zone)

    public List<List<String>> getMarketData() {
        return marketData;
    }

    public void setMarketData(List<List<String>> marketData) {
        this.marketData = marketData;
    }
}
