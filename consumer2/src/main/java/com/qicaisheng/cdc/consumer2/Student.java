package com.qicaisheng.cdc.consumer2;

/**
 * Created by stong on 5/9/17.
 */
public class Student {
    private long id;
    private int age;

    public Student() {
    }

    public Student(long id, int age) {
        this.id = id;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
