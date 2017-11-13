package com.xugc.demo.entity;

/**
 * Created by xuguocheng on 2017/9/21.
 */
public class UmUser {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UmUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
