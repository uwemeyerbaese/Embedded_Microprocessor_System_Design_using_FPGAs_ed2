// An OOP Inheritance Example
public class Quadrilateral {
  double side1, side2, side3, side4; // instance variables

  // Quadrilateral constructor receives 4 parameters
  public Quadrilateral(double a, double b, double c, double d) {
    this.side1 = a; // assign name to 1. instance variable
    this.side2 = b; // assign name to 2. instance variable
    this.side3 = c; // assign name to 3. instance variable
    this.side4 = d; // assign it to 4. instance variable
  }

  // Method that computes and display perimeter
  public void perimeter() {
    double p = this.side1 + this.side2 + this.side3 + this.side4;
    System.out.println("Perimeter = " + p);
  }
}

