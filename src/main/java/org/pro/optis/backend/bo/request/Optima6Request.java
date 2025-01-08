package org.pro.optis.backend.bo.request;

import java.util.List;

public class Optima6Request {
    private List<Integer> demand;
    private List<Integer> production;
    private List<List<Integer>> transportCost;

    public List<Integer> getDemand() {
        return demand;
    }

    public void setDemand(List<Integer> demand) {
        this.demand = demand;
    }

    public List<Integer> getProduction() {
        return production;
    }

    public void setProduction(List<Integer> production) {
        this.production = production;
    }

    public List<List<Integer>> getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(List<List<Integer>> transportCost) {
        this.transportCost = transportCost;
    }
}
