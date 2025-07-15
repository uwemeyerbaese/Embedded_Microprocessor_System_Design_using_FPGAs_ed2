public class DefaultOverload {
  public static double calc(double a, double b, String op) {
    if (op.equals("add")) return a + b;
    if (op.equals("sub")) return a - b;
    // not add or sub:
    System.out.println(op + " is not a valid operation");
    System.exit(-1);
    return -1;
  }

  // Use overload method to implement a default parameter
  public static double calc(double x, double y) {
    String op = "add"; // default operation
    return calc(x, y, op);
  }

  public static void main(String[] args) {
    // call the method
    System.out.println("calc(10, 4, \"add\") = " + calc(10, 4, "add")); // returns 14
    System.out.println("calc(10, 4) = " + calc(10, 4));                 // also 14:default "op" is "add"
    System.out.println("calc(10, 4, \"sub\") = " + calc(10, 4, "sub")); // returns 6
    System.out.println("calc(10, 4, \"div\") = " + calc(10, 4, "div")); // prints error message
  }
}