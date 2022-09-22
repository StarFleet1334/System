package com.solvd.app.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty
    private String street;
    @JsonProperty
    private String city;
    @JsonProperty
    private String zipcode;


    public Address() {}

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


}
