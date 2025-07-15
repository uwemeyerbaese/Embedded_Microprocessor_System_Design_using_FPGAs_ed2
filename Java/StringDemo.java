import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.*; // wildcard * can be used for the 4 classes

public class StringDemo {
  public static void main(String[] args) {
    System.out.println("*** Working with Strings");
    System.out.println("*** define within double quotes \"...\"");
    String s = "I like Java !";
    System.out.println(s);
    String t = s.toLowerCase();
    System.out.println(t);
    String u = s.toUpperCase();
    System.out.println(u);
    String w = s.replace("like", "love");
    System.out.println(w);
    int x = s.indexOf("Java");
    System.out.println("Java index = " + x);
    // not found gives -1
    int y = s.indexOf("vhdl");
    System.out.println("vhdl index = " + y);
    // split into a list of words
    String[] z = s.split(" ", 5);
    for (String word : z) System.out.println(word);

  }
}
