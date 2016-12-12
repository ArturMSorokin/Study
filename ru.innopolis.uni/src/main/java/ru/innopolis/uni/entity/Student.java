package ru.innopolis.uni.entity;

/**
 * Created by olymp on 10.12.2016.
 */
public class Student {
    private long version=1L;

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

    private long id;
    private String name;
    private int age;
}
