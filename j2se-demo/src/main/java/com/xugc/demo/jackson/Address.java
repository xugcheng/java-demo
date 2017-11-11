package com.xugc.demo.jackson;

import java.util.Arrays;
import java.util.Date;

public class Address {

    private String name;

    public Integer code;

    private Date date;

    private String[] city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String[] getCity() {
        return city;
    }

    public void setCity(String[] city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", code=" + code +
                ", date=" + date +
                ", city=" + Arrays.toString(city) +
                '}';
    }
}
