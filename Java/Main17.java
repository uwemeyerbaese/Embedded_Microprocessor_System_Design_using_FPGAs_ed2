// An OOP Generate: equals, hashCode, toString Example

import java.util.HashSet;

public class Main17 {
  public static void main(String[] args) {
    String lineSeparator = "";
    for (int k = 0; k < 26; k++) lineSeparator += "=";
    System.out.println(lineSeparator);
    Quadrilateral17 q1 = new Quadrilateral17(7, 5, 6, 4);
    System.out.println("Quadrilateral: 7, 5, 6, 4");
    System.out.println("Default Object methods:");
    System.out.println("Quadrilateral: " + q1);
    Quadrilateral17 q2 = new Quadrilateral17(7, 5, 6, 4);
    System.out.println("Same ? " + q1.equals(q2));
    var set = new HashSet<Quadrilateral17>();
    set.add(q1);    set.add(q2);    set.add(q1);    set.add(q2);
    System.out.println("Set size ? " + set.size());
    System.out.println(lineSeparator);
  } // end main
}