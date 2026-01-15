import java.util.*;

public class Triangle extends Shape {

    private double base, height, side1, side2, side3;

    public Triangle(double base, double height, double s1, double s2, double s3) {
        this.base = base;
        this.height = height;
        this.side1 = s1;
        this.side2 = s2;
        this.side3 = s3;
    }

    double area() {
        return 0.5 * base * height;
    }

    double perimeter() {
        return side1 + side2 + side3;
    }
}
