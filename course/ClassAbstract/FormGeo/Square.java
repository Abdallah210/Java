package course.ClassAbstract.FormGeo;


public class Square extends Form {

    private double side;

    public Square(double side){
        this.side = side;

    }


    @Override
    public double calculateArea() {
        return side*side;        
    }

    
}