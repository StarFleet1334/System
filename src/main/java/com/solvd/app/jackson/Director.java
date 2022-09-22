package com.solvd.app.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Director {
    @JsonProperty
    private String name;
    @JsonProperty
    private Prop prop;

    public Director() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Prop getProp() {
        return prop;
    }

    public void setProp(Prop prop) {
        this.prop = prop;
    }


}
