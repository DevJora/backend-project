package org.pro.optis.backend.bo;

import java.util.Map;

public class Optima9Response {
    private Map<String, Integer> segments;  // Résultat de segmentation par catégorie

    public Optima9Response(Map<String, Integer> segments) {
        this.segments = segments;
    }

    public Map<String, Integer> getSegments() {
        return segments;
    }
}
