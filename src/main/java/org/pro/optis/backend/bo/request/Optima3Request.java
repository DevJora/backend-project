package org.pro.optis.backend.bo.request;


import java.util.List;

public class Optima3Request {
    private String productName;
    private int stock;
    private double storageCost;
    private double shortageCost;
    private double preparationCost;
    private List<Optima3Request> products;

    // Getters et Setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getStorageCost() {
        return storageCost;
    }

    public void setStorageCost(double storageCost) {
        this.storageCost = storageCost;
    }

    public double getShortageCost() {
        return shortageCost;
    }

    public void setShortageCost(double shortageCost) {
        this.shortageCost = shortageCost;
    }

    public double getPreparationCost() {
        return preparationCost;
    }

    public void setPreparationCost(double preparationCost) {
        this.preparationCost = preparationCost;
    }

    public List<Optima3Request> getProducts() {
        return products;
    }

    public void setProducts(List<Optima3Request> products) {
        this.products = products;
    }

    public static class Product {
        private String productName;
        private int stock;
        private double storageCost;
        private double shortageCost;
        // Getters et Setters

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public double getStorageCost() {
            return storageCost;
        }

        public void setStorageCost(double storageCost) {
            this.storageCost = storageCost;
        }

        public double getShortageCost() {
            return shortageCost;
        }

        public void setShortageCost(double shortageCost) {
            this.shortageCost = shortageCost;
        }
    }
}

