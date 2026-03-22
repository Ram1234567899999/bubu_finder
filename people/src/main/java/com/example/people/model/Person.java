package com.example.people.model;

public class Person {
    private String name;
    private String phone;
    private String zip;

    public Person() {
    }

    public Person(String name, String phone, String zip) {
        this.name = name;
        this.phone = phone;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
