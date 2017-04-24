package com.vaidu.shahinvai.ViewContacs;

/**
 * Created by Guitorio on 4/23/2017.
 */
public class Student {
    String id,name;

    public Student() {
    }

    public Student(String id, String name) {

        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
