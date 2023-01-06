package org.example;

import java.util.Objects;

public class PersonKey {
    int age;
    long salary;
    Department department;

    public PersonKey(int age, long salary, Department department) {
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonKey personKey)) return false;
        return getAge() == personKey.getAge() && getSalary() == personKey.getSalary() && getDepartment() == personKey.getDepartment();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getSalary(), getDepartment());
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


}
