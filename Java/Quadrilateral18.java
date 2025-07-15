// An OOP record: equals, hashCode, toString Example

public record Quadrilateral18 (
  double side1, double side2, double side3, double side4) // instance variables
{
  // Quadrilateral record does not need a constructor

  // Method that computes and display perimeter
  public void perimeter() {
    double p = this.side1 + this.side2 + this.side3 + this.side4;
    System.out.println("Perimeter = " + p);
  }
}

