// An OOP Generate: equals, hashCode, toString Example
public class Quadrilateral17 {
  double side1, side2, side3, side4; // instance variables

  // Quadrilateral constructor receives 4 parameters
  public Quadrilateral17(double a, double b, double c, double d) {
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

  @Override
  public String toString() {
    return "Quadrilateral17{" +
            "side1=" + side1 +
            ", side2=" + side2 +
            ", side3=" + side3 +
            ", side4=" + side4 +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Quadrilateral17 that = (Quadrilateral17) o;

    if (Double.compare(that.side1, side1) != 0) return false;
    if (Double.compare(that.side2, side2) != 0) return false;
    if (Double.compare(that.side3, side3) != 0) return false;
    return Double.compare(that.side4, side4) == 0;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    temp = Double.doubleToLongBits(side1);
    result = (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(side2);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(side3);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(side4);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }
}

