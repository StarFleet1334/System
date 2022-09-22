package com.solvd.app.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Company {
    @JsonProperty
    private String name;
    @JsonProperty
    private Address address;
    @JsonProperty
    private Contacts contacts;
    @JsonProperty
    private String numberEmp;
    @JsonProperty
    private Director director;
    @JsonProperty
    private List<Manager> manager;
    @JsonProperty
    private List<String> partnerCompanies;
    @JsonProperty
    private String head_quarter;
    @JsonProperty
    private List<String> cities;
    @JsonProperty
    private String connections;

    public Company(){}

    public Company(String name,Address address,Contacts contacts,
                   String number_of_employee,Director director,
                   List<Manager> managersList,List<String> partner_list,
                   String head_quarter,List<String> cities,String connections) {
        this.name = name;
        this.address = address;
        this.contacts = contacts;
        this.numberEmp = number_of_employee;
        this.director = director;
        this.manager = managersList;
        this.partnerCompanies = partner_list;
        this.head_quarter = head_quarter;
        this.cities = cities;
        this.connections = connections;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public String getNumberEmp() {
        return numberEmp;
    }

    public void setNumberEmp(String numberEmp) {
        this.numberEmp = numberEmp;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Manager> getManager() {
        return manager;
    }

    public void setManager(List<Manager> manager) {
        this.manager = manager;
    }

    public List<String> getPartner_list() {
        return partnerCompanies;
    }

    public void setPartnerCompanies(List<String> partnerCompanies) {
        this.partnerCompanies = partnerCompanies;
    }

    public String getHead_quarter() {
        return head_quarter;
    }

    public void setHead_quarter(String head_quarter) {
        this.head_quarter = head_quarter;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public String getConnections() {
        return connections;
    }

    public void setConnections(String connections) {
        this.connections = connections;
    }


}
