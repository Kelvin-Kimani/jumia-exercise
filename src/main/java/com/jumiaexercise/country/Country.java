package com.jumiaexercise.country;

public class Country {
    private String countryName;
    private String countryCode;
    private String countryPrefix;

    public Country(String countryName, String countryCode, String countryPrefix) {
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.countryPrefix = countryPrefix;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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
