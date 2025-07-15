// This is how we could define a user module
package pack;  
public class Util3{  

  public void msg(){ System.out.println("Hello from Uwe's Util3"); }  

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