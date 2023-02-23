package day3;

import java.util.Scanner;

interface CalculateArea {
    double getArea();
    double getPerimeter();
}

interface CalculateVolume {
    double getSurfaceArea();
    double getVolume();
}

class Circle implements CalculateArea {
    private double radius;
    private final double pi = Math.PI;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    public double getArea() {
        return pi * radius * radius;
    }
    
    public double getPerimeter() {
        return 2 * pi * radius;
    }
}

class Square implements CalculateArea {
    private double side;
    
    Square(double side) {
        this.side = side;
    }
    
    public double getArea() {
        return side * side;
    }
    
    public double getPerimeter() {
        return 4 * side;
    }
}

class Triangle implements CalculateArea {
    private double a;
    private double b;
    private double c;
    
    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public double getArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    
    public double getPerimeter() {
        return a + b + c;
    }
}

class Sphere implements CalculateArea, CalculateVolume {
    private double radius;
    private final double pi = Math.PI;
    
    Sphere(double radius) {
        this.radius = radius;
    }
    
    public double getArea() {
        return 4 * pi * radius * radius;
    }
    
    public double getPerimeter() {
        return 2 * pi * radius;
    }
    
    public double getSurfaceArea() {
        return 4 * pi * radius * radius;
    }
    
    public double getVolume() {
        return (4/3) * pi * radius * radius * radius;
    }
}

class Cuboid implements CalculateArea, CalculateVolume  {
    private double side;
    
    Cuboid(double side) {
        this.side = side;
    }
    
    public double getArea() {
        return side * side;
    }
    
    public double getPerimeter() {
        return 4 * side;
    }
    
    public double getSurfaceArea() {
        return 6 * side * side;
    }
    
    public double getVolume() {
        return side * side * side;
    }
}

public class CalculateAreaAndVolume {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the radius for circle: ");
		double radius = sc.nextDouble();
		Circle c = new Circle(radius);
		System.out.println("Circle area: " + c.getArea());
		System.out.println("Circle perimeter: " + c.getPerimeter());
        
		System.out.println("\nEnter the length for square: ");
		double side = sc.nextDouble();
		Square s = new Square(side);
		System.out.println("Square area: " + s.getArea());
		System.out.println("Square perimeter: " + s.getPerimeter());

		System.out.println("\nEnter the a, b and c for circle: ");
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double three = sc.nextDouble();
		Triangle t = new Triangle(a, b, three);
		System.out.println("Triangle area: " + t.getArea());
		System.out.println("Triangle perimeter: " + t.getPerimeter());

		System.out.println("\nEnter the radius for sphere: ");
		double sph = sc.nextDouble();
		Sphere sp = new Sphere(sph);
		System.out.println("Sphere area: " + sp.getArea());
		System.out.println("Sphere perimeter: " + sp.getPerimeter());
		System.out.println("Sphere surface area: " + sp.getSurfaceArea());
		System.out.println("Sphere volume: " + sp.getVolume());

		System.out.println("\nEnter the side for cuboid: ");
		double si = sc.nextDouble();
		Cuboid cu = new Cuboid(si);
		System.out.println("Cuboid area: " + cu.getArea());
		System.out.println("Cuboid perimeter: " + cu.getPerimeter());
		System.out.println("Cuboid surface area: " + cu.getSurfaceArea());
		System.out.println("Cuboid volume: " + cu.getVolume());
		sc.close();
    }
}
