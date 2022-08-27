package Schooling;

import java.util.List;

public class Universite {

    private String name;
    private Student[] students;
    
    public Universite(String name, Student[] s) {
        this.name = name;
        this.students = s;
    }


    public static void main(String[] args) {
        
        Student s1 = new Student("A", "a", 1, 1);
        Student s2 = new Student("B", "b", 2, 1);
        Student s3 = new Student("C", "c", 3, 1);
        Student s4 = new Student("D", "d", 4, 1);


        Student[] ss = {null, null, null};

        System.out.println(ss[0]);
        System.out.println(ss[1]);
        System.out.println(ss[2]);

        ss[0] = null;

        System.out.println(ss[0]);

        // ss[3] = s4;

    }
    
}
