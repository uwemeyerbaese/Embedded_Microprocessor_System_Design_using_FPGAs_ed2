// An OOP inheritance Example
public class Rectangle extends Quadrilateral {
  double sideA, sideB; // instance variables

  // Rectangle constructor receives two parameters
  public Rectangle(double a, double b) {
    super(a, b, a, b); // Enable super class methods
    this.sideA = a; // assign name to 1. instance variable
    this.sideB = b; // assign name to 2. instance variable
  }

  // Add rectangle method that computes and display area
  public void area() {
    double ab = this.sideA * this.sideB;
    System.out.println("Area of rectangle = " + ab);
  }
}

