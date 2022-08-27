package course.ClassAbstract.FormGeo;


public abstract class Form {
    
    // the abstract class is made just to be inherited
    // the abstract class cannot be instantied : can not create a object of this class

    public abstract double calculateArea();

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}