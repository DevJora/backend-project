package org.pro.optis.backend.bo;

import java.util.Map;

public class Optima8Response {
    private Map<String, Integer> segments;  // Résultat de segmentation par catégorie

    public Optima8Response(Map<String, Integer> segments) {
        this.segments = segments;
    }

    public Map<String, Integer> getSegments() {
        return segments;
    }
}
