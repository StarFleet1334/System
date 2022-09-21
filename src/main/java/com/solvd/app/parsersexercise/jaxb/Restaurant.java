package com.solvd.app.parsersexercise.jaxb;

import javax.xml.bind.annotation.*;


@XmlRootElement(name = "restaurant")
public class Restaurant {
    private int id;
    private Address address;
    private Food food;

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", address=" + address +
                ", food=" + food +
                '}';
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Restaurant() {}

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
