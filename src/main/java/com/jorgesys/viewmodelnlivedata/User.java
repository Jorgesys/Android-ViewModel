package com.jorgesys.viewmodelnlivedata;

class User {


    public User(int age, String name, String lastName){
        this.age = age;
        this.name = name;
        this.lastName = lastName;
    }

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
