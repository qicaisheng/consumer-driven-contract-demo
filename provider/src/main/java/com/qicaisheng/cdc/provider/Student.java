package com.qicaisheng.cdc.provider;

/**
 * Created by stong on 5/9/17.
 */
public class Student {
    private long id;
    private String name;
    private int age;

    public Student() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}