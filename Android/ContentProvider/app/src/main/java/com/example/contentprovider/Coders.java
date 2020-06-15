package com.example.contentprovider;

public class Coders {

    private String name ;

    public Coders(String name) {
        this.name = name;
    }

    public Coders() {
    }

    @Override
    public String toString() {
        return "Coders{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
