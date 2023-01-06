package org.example;

public class Person {
    int age;
    long salary;
    double tenor;
    String name;
    Department department;

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }

    public double getTenor() {
        return tenor;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public Person(int age, int salary, double tenor, String name, Department dept) {
        this.age = age;
        this.salary = salary;
        this.tenor = tenor;
        this.name = name;
        this.department =dept;
    }
}
