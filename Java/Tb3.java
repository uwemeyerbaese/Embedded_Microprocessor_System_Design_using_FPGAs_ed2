// Save as Tb3.java; compile with:
// $ javac javac -d . Util1.java Util2.java Util3.java Tb3.java
// Build the jar file with:
// jar cvf util.jar pack
// Run with
// $ java -classpath .;util.jar mypack.Tb3
package mypack;
import pack.*;

class Tb3 {
  public static void main(String args[]) {
    // Run some tests for the user libraries
    Util1 o1 = new Util1();
    o1.msg();
    System.out.println("NUM1 = " + o1.NUM1);

    Util2 o2 = new Util2();
    o2.msg();
    System.out.println("NUM2 = " + o2.NUM2);

    Util3 o3 = new Util3();
    o3.msg();
    long r = o3.calc(o2.NUM2, o1.NUM1, "sub");
    System.out.println("NUM2 - NUM1 = " + r);
    r = o3.calc(3, 5, "mul");
  }
}  