package course.ClassAbstract.FormGeo;


public class MainClass {

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Square square = new Square(2.5);
        Triangle triangle = new Triangle(4, 2.5);
    
    
        System.out.println("Circle area : " + circle.calculateArea());
        System.out.println("Square area : " + square.calculateArea());
        System.out.println("Triangle area : " + triangle.calculateArea());
    }


    
}
