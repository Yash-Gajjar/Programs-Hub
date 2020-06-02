package com.practice;

public class BasicClassOperations {
    public static void main(String[] args) {

        Student student1 = new Student("CoderBoy", 123456789) ;
        Student student2 = new Student(student1) ; // Passing Object as Argument

        System.out.println("Student 1: ");
        System.out.println(student1.getName());
        System.out.println(student1.getNumber());

        System.out.println("Student 2: ");
        System.out.println(student2.getName());
        System.out.println(student2.getNumber());

    }
}

class Student {
    private String name ;
    private long number ;

    public Student(String name, long number) {
        this.name = name;
        this.number = number;
    }

    public Student(Student student) {
        this.name = student.getName() ;
        this.number = student.getNumber() ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
