package course.ClassAbstract.FormGeo;

import java.lang.Math;

public class Circle extends Form {

    private int radius;
    //private int diameter;
    //private static final double PI = 3.14;   *it's better using Math package*


    public Circle(int radius) {
        this.radius = radius;
        //this.diameter = radius*2; 
    }

    @Override
    public double calculateArea() {
        return Math.pow(radius,2)*Math.PI;       
    }

    
}
