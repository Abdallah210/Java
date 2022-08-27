package Schooling;

import java.lang.Math;


public class Student {

    private String firstname;
    private String lastname;
    private int age;
    //private int studentNum;
    private int yearOfStudy;

    public Student(String fn, String ln, int age, int ys) {

        this.firstname = fn;
        this. lastname = ln;
        this.age = age;
        this.yearOfStudy = ys;

        //not fixed :(
        /*int num = (int) ( Math.random() * Math.pow(10,9));
        this.studentNum = num;*/
    }

    public int getAge() {
        return this.age;
    }

    public String getFirstname() {
        return this.firstname;
    }
    
    public String getLastname() {
        return this.lastname;
    }

    /*public int getStudentNum() {
        return this.studentNum;
    }*/
    
    public int getYearOfStudy() {
        return this.yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    /*
    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }*/

    public static void main(String[] args) {
        Student student1 = new Student("Abdallah", "El Filali", 22, 2);
        
        System.out.println(student1.getFirstname());
        System.out.println(student1.getLastname());
        System.out.println(student1.getAge());
        System.out.println(student1.getYearOfStudy());
        //System.out.println(student1.getStudentNum());
    }
}