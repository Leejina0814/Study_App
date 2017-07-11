package com.example.leejinah.myapplication;

/**
 * Created by Lee JinAh on 2017-07-10.
 */

public class Student {
    private String name;
    private String id;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "이름 =" + name +
                "\n학번 =" + id + "\n";
    }
}
