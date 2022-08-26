package com.revature.models;

import java.util.List;

public class Order {
    private int id;
    private int customer_id;
    private double total;
    // TODO edit this property change the Product POJO to some
    // other POJO that pairs products and their quanties together
    private List<LineItem> lineItems;

    public Order() {
        super();
    }

    public Order(int id, int customer_id, double total, List<LineItem> lineItems) {
        this.id = id;
        this.customer_id = customer_id;
        this.total = total;
        this.lineItems = lineItems;
    }

    @Override
    public String toString() {
        return "Order [customer_id=" + customer_id + ", id=" + id + ", lineItems=" + lineItems + ", total=" + total
                + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

}
