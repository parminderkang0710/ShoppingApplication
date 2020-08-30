package com.example.project1;

/**
 * created by Gurbir Singh
 */

public class Order {
    /**
     * attributes
     */

    String id, pizza, size, total, userid;
    int price, qty;

    public Order() {
    }

    /**
     * values for attibutes
     * @param id
     * @param pizza
     * @param size
     * @param total
     * @param userid
     * @param price
     * @param qty
     */
    public Order(String id, String pizza, String size, String total, String userid, int price, int qty) {
        this.id = id;
        this.pizza = pizza;
        this.size = size;
        this.total = total;
        this.userid = userid;
        this.price = price;
        this.qty = qty;
    }

    /**
     * getter and setter
     * to set and get the values of declared attributes
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
