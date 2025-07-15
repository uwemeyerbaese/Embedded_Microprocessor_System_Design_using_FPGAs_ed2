// An OOP RECORD: equals, hashCode, toString Example
import java.util.HashSet;
public class Main19 {
  public static void main(String[] args) {
    System.out.println("=".repeat(50)); // Needs SDK8+
    Quadrilateral18 q1 = new Quadrilateral18(7, 5, 6, 4);
    System.out.println("Record generates correct equals, hashCode, toString methods:");
    System.out.println("Quadrilateral: " + q1);
    Quadrilateral18 q2 = new Quadrilateral18(7, 5, 6, 4);
    System.out.println("Same ? " + q1.equals(q2));
    var set = new HashSet<Quadrilateral18>();
    set.add(q1); set.add(q2); set.add(q1); set.add(q2); // No repetitions !
    System.out.println("Set size ? " + set.size());
    System.out.println("=".repeat(50)); // Needs SDK8+
  }
}