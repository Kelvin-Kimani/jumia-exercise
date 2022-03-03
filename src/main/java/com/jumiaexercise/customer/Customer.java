package com.jumiaexercise.customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Customer {

    @Id
    private int id;
    private String name;
    private String phone;

    @Transient
    private String country;

    @Transient
    private String state;

    @Transient
    private String countryCode;

    @Transient
    private String countryPrefix;


    public Customer(int id, String name, String phone, String country, String state, String countryCode, String countryPrefix) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.country = country;
        this.state = state;
        this.countryCode = countryCode;
        this.countryPrefix = countryPrefix;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryPrefix() {
        return countryPrefix;
    }

    public void setCountryPrefix(String countryPrefix) {
        this.countryPrefix = countryPrefix;
    }
}
