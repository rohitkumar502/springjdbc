package org.ms.spring_jdbc.entities;

public class Student {
    private int id;
    private String name;
    private String city;


    // Creating getter and setter methods for property injection
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Student()
    { }

    // Creating parameterized constructor for constructor injection
    public Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student [id = "+ id + ", name = "+ name + ", city = " + city + ']';
    }


}
