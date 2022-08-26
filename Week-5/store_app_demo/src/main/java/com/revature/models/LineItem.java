package com.revature.models;

public class LineItem {
    private Product product;
    private int quantity;
    private int id;

    public LineItem(Product product, int quantity, int id) {
        this.product = product;
        this.quantity = quantity;
        this.id = id;
    }

    public LineItem() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LineItem [id=" + id + ", product=" + product + ", quantity=" + quantity + "]";
    }

}
