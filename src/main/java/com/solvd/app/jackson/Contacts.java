package com.solvd.app.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contacts {
    @JsonProperty
    private String local;
    @JsonProperty
    private String global;

    public Contacts() {}

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getGlobal() {
        return global;
    }

    public void setGlobal(String global) {
        this.global = global;
    }

}
