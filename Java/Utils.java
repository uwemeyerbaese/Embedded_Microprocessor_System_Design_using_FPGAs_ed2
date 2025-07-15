// This is how we could define a user library
package pack;

public class Utils {
  public void msg() {
    System.out.println("Hello from Uwe's Utils");
  }

  // Public constants that will be exported
  public final long NUM1 = 9783030505325L;
  public final long NUM2 = 9783030505332L;

  /* Small calculator for add and sub */
  /* Default is used of op */
  public static long calc(long a, long b, String op) {
    if (op.equals("add")) return a + b;
    if (op.equals("sub")) return a - b;
    // not add or sub:
    System.out.println(op + " is not a valid operation");
    System.exit(-1);
    return -1;
  }

  // Use overload method to implement a default parameter
  public static long calc(long x, long y) {
    String op = "add"; // default operation
    return calc(x, y, op);
  }
}