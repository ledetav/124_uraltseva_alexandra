package task;

public class Triangle{

    //fields
    private double a, b, c;

    //constructor
    public Triangle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    //methods
    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }
    public double getC(){
        return c;
    }

    public boolean isValid(){
        return a > 0 && b > 0 && c > 0 && (a+b) > c && (a+c) > b && (b+c) > a;
    }

    public double perimeter(){
        if(isValid())
            return a+b+c;
        else
            return -1;
    }
    private double halfPerimeter(){
        if(isValid())
            return perimeter()/2;
        else
            return -1;
    }
    public double square(){
        if(isValid()){
            double p = halfPerimeter();
            return Math.sqrt(p*(p-a)*(p-b)*(p-c));
        } else
            return -1;
    }
}