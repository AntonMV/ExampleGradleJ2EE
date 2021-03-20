package ru.mikhaylov.model;

import javax.enterprise.inject.Alternative;

//@AnnotationStudent
@Alternative
public class Student implements Person{
   private int age;
   private String name;

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public Student() {
    }

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

    @Override
    public String toString() {
        return "Student";
    }
}
