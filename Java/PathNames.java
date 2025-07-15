// When using import package path names are shorter
// The package java.lang is imported by default

import java.util.Random;
import static java.lang.Math.pow;

public class PathNames {
  public static void main(String[] args) {
    // Default import for java.lang/no import needed for Math
    System.out.printf("sin(pi/3)= %.3f\n", Math.sin(Math.PI / 3));
    System.out.printf("sin(pi/3)= %.3f\n", java.lang.Math.sin(java.lang.Math.PI / 3));

    // java.util package has classes: Random, List, Collections, etc.
    Random randomInt = new Random(0); // Random number with seed
    System.out.printf("Random  int 0..100 = %d\n", randomInt.nextInt(101));

    // Use complete path name if no import specified
    Random r = new java.util.Random(0);
    System.out.printf("Random  int 0..100 = %d\n", r.nextInt(101));

    // Static method import require NO path; but watch for name conflicts
    double p = pow(3.0, 0.5);
    System.out.printf("0.5*2^.5 = sqrt(3)/2 = %.3f\n", p / 2);
  }
}
