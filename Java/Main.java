// An OOP Inheritance Example
public class Main {
  public static void main(String[] args) {
    String lineSeparator = "";
    for (int k = 0; k < 26; k++) lineSeparator += "=";
    System.out.println(lineSeparator);
    Quadrilateral q1 = new Quadrilateral(7, 5, 6, 4);
    System.out.println("Quadrilateral: 7, 5, 6, 4");
    q1.perimeter();

    System.out.println(lineSeparator);
    Rectangle r1 = new Rectangle(10, 20);
    System.out.println("Rectangle: 10, 20");
    r1.perimeter();
    r1.area();
  } // end main
}