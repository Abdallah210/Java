package course.ClassAbstract.FormGeo;


public class Triangle extends Form {

    private double height;
    private double base;


    public Triangle(double height, double base) {
        this.height = height;    
        this.base = base;    
    }

    @Override
    public double calculateArea() {
        return (height*base)/2;        
    }
    
}
