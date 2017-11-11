package com.xugc.demo.xstream.domain;

public class Person {

    private String firstName;

    private String lastName;

    private PhoneNumber phone;

    private PhoneNumber fax;

    private String x_y;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PhoneNumber getPhone() {
        return phone;
    }

    public void setPhone(PhoneNumber phone) {
        this.phone = phone;
    }

    public PhoneNumber getFax() {
        return fax;
    }

    public void setFax(PhoneNumber fax) {
        this.fax = fax;
    }

    public String getX_y() {
        return x_y;
    }

    public void setX_y(String x_y) {
        this.x_y = x_y;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                ", fax=" + fax +
                ", x_y='" + x_y + '\'' +
                '}';
    }
}

