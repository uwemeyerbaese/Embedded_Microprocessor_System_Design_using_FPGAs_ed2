// Save as Tb.java; compile with:
// $ javac -d . Utils.java Tb.java
// Run with
// $ java mypack.Tb
package mypack;
import pack.*;

class Tb {
  public static void main(String args[]) {
    // Run some tests for the user library
    Utils obj = new Utils();
    obj.msg();

    System.out.println("NUM1 = " + obj.NUM1);
    System.out.println("NUM2 = " + obj.NUM2);

    long r = obj.calc(obj.NUM2, obj.NUM1, "sub");
    System.out.println("NUM2 - NUM1 = " + r);
    r = obj.calc(3, 5, "mul");
  }
}  