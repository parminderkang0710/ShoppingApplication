package com.example.project1;

/**
 * created by Gurbir Singh
 */

public class Pizza {

    String id, name, price;

    public Pizza() {
    }

    /**
     * values given for attributes
     * @param id
     * @param name
     * @param price
     */
    public Pizza(String id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * getter and setter used
     * to get and set new values or results
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
