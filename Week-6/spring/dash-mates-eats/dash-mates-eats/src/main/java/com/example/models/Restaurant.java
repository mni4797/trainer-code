package com.example.models;

import java.util.List;

/**
 * POJO restaurant
 * Nothing special here
 */
public class Restaurant {
    private int id;
    private String name;
    List<MenuItem> menu;

    public Restaurant() {
    }

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

}
