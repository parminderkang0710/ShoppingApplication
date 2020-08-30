package com.example.project1;

/**
 * created by Gurbir Singh
 */
public class User {
    /**
     * attributes
     */
    String id, name, email, address, mobile, city;

    public User() {
    }

    /**
     *
     * @param id
     * @param name
     * @param email
     * @param address
     * @param mobile
     * @param city
     */
    public User(String id, String name, String email, String address, String mobile, String city) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.mobile = mobile;
        this.city = city;
    }

    /**
     * getter and stter
     * to set and get return values for attributes
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
