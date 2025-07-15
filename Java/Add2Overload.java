public class Add2Overload {
  public static void main(String[] args) {
    // create two each of Integer, Double, and String
    int i1 = 5, i2 = 7;
    double d1 = 2.75, d2 = 4.5;
    String s1 = "Hello", s2 = " Java";

    System.out.println("Add 2 integers: result = " + add2(i1, i2));
    System.out.println("Add 2 doubles:  result = " + add2(d1, d2));
    System.out.println("Add 2 strings:  result = " + add2(s1, s2));
  }
  // method Integer add
  public static int add2(int i1, int i2) { 
  return i1 + i2; }

  // method Double add
  public static double add2(double d1, double d2) { 
  return d1 + d2; }

  // method String add
  public static String add2(String s1, String s2) { 
  return s1 + s2; }
}
