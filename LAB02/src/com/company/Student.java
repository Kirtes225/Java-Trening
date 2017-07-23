package com.company;

import java.util.List;

public class Student implements Comparable<Student> {
    private static int id = 0;
    private String name, surname;
    private StudentType type;
    private List<Activity> activities;

    public Student(String name, String surname, StudentType type) {
        this.id++;
        this.name = name;
        this.surname = surname;
        this.type = type;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Student.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public StudentType getType() {
        return type;
    }

    public void setType(StudentType type) {
        this.type = type;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public int compareTo(Student o) {
        int cmp = name.compareTo(o.name);
        if(cmp == 0){
            cmp = surname.compareTo(o.surname);
        }
        return cmp;
    }
}
