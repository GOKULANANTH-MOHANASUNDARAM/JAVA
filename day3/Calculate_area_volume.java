package day3;

import java.util.Scanner;

interface Calculate_area {
    double area();
    double perimeter();
}

interface Calculate_volume {
    double surfaceArea();
    double volume();
}

class Circle implements Calculate_area {
    private double radius;
    private final double pi = Math.PI;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    public double area() {
        return pi * radius * radius;
    }
    
    public double perimeter() {
        return 2 * pi * radius;
    }
}

class Square implements Calculate_area {
    private double side;
    
    Square(double side) {
        this.side = side;
    }
    
    public double area() {
        return side * side;
    }
    
    public double perimeter() {
        return 4 * side;
    }
}

class Triangle implements Calculate_area {
    private double a;
    private double b;
    private double c;
    
    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public double area() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    
    public double perimeter() {
        return a + b + c;
    }
}

class Sphere implements Calculate_area, Calculate_volume {
    private double radius;
    private final double pi = Math.PI;
    
    Sphere(double radius) {
        this.radius = radius;
    }
    
    public double area() {
        return 4 * pi * radius * radius;
    }
    
    public double perimeter() {
        return 2 * pi * radius;
    }
    
    public double surfaceArea() {
        return 4 * pi * radius * radius;
    }
    
    public double volume() {
        return (4/3) * pi * radius * radius * radius;
    }
}

class Cuboid implements Calculate_area, Calculate_volume  {
    private double side;
    
    Cuboid(double side) {
        this.side = side;
    }
    
    public double area() {
        return side * side;
    }
    
    public double perimeter() {
        return 4 * side;
    }
    
    public double surfaceArea() {
        return 6 * side * side;
    }
    
    public double volume() {
        return side * side * side;
    }
}

public class Calculate_area_volume {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the radius for circle: ");
		double radius = sc.nextDouble();
		Circle c = new Circle(radius);
		System.out.println("Circle area: " + c.area());
		System.out.println("Circle perimeter: " + c.perimeter());
        
		System.out.println("\nEnter the length for square: ");
		double side = sc.nextDouble();
		Square s = new Square(side);
		System.out.println("Square area: " + s.area());
		System.out.println("Square perimeter: " + s.perimeter());

		System.out.println("\nEnter the a, b and c for circle: ");
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double three = sc.nextDouble();
		Triangle t = new Triangle(a, b, three);
		System.out.println("Triangle area: " + t.area());
		System.out.println("Triangle perimeter: " + t.perimeter());

		System.out.println("\nEnter the radius for sphere: ");
		double sph = sc.nextDouble();
		Sphere sp = new Sphere(sph);
		System.out.println("Sphere area: " + sp.area());
		System.out.println("Sphere perimeter: " + sp.perimeter());
		System.out.println("Sphere surface area: " + sp.surfaceArea());
		System.out.println("Sphere volume: " + sp.volume());

		System.out.println("\nEnter the side for cuboid: ");
		double si = sc.nextDouble();
		Cuboid cu = new Cuboid(si);
		System.out.println("Cuboid area: " + cu.area());
		System.out.println("Cuboid perimeter: " + cu.perimeter());
		System.out.println("Cuboid surface area: " + cu.surfaceArea());
		System.out.println("Cuboid volume: " + cu.volume());
		sc.close();
    }
}
