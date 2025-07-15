import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read
import java.io.PrintWriter; // Import to write to file

public class io {
  public static void main(String[] args) {
    int i = 0;
    String s = "";
    double d = 0.0;
    int argc = args.length;
    System.out.println("Argument count =" + argc);
    for (int k = 0; k < argc; k++) {
      System.out.println(k + ": " + args[k]);
    }
    switch (argc) { // Switch based on the line inputs
      case 0: // Zero command line inputs
        System.out.println("Please enter INT STRING DOUBLE");
        Scanner keyboard = new Scanner(System.in);
        i = keyboard.nextInt();
        s = keyboard.next();
        d = keyboard.nextDouble();
        break;
      case 1: // An input File is given
        String inFileName = args[0];
        try {
          // Open the file for reading
          File inFile = new File(inFileName);
          Scanner myReader = new Scanner(inFile);
          while (myReader.hasNextLine()) {
            i = myReader.nextInt();
            s = myReader.next();
            d = myReader.nextDouble();
            //System.out.println("i=" + i + "; s= " + s + "; d= " + d); // Debug print
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("File " + inFileName + " not found!");
          e.printStackTrace();
          System.exit(0);
        }
        System.out.println("Done reading 3 inputs from FILE");
        break;
      case 3:
        System.out.println("Done reading 3 inputs from STDIN");  // all 3 given//
        try {
          i = Integer.parseInt(args[0]);
          s = args[1];
          d = Double.parseDouble(args[2]);
          // System.out.println("i=" + i + "; s=" + s + "; d=" + d); // Debug print
        } catch (Exception e) {
          System.err.println(e);
          System.out.println("Format error in parameter  -- Good bye");
          System.exit(0);
        }
        break;
      default:
        System.out.println("Wrong parameter number -- Good bye");
        System.exit(0);
    }
    System.out.println("Reading done -- Start Processing");
    // Print integer in different formats
    System.out.printf("dec = %d  octal = %o  hex = %04x  char = %c\n", i, i, i, i);
    // Print first and last character and whole string
    int L = s.length() - 1;
    System.out.printf("first = %c ... last = %c  whole = %s\n", s.charAt(0), s.charAt(L), s);
    // Print double in 3 formats
    System.out.printf("exp = %e  std = %f  short = %g\n", d, d, d);
    String outFileName = "example.txt";
    try {
      PrintWriter outFile = new PrintWriter(outFileName);
      System.out.printf("Writing the file:  %s\n", outFileName);
      outFile.printf("dec = %d  octal = %o  hex = %04x  char = %c\n", i, i, i, i);
      outFile.printf("first = %c ... last = %c  whole = %s\n", s.charAt(0), s.charAt(L), s);
      outFile.printf("exp = %e  std = %f  short = %g\n", d, d, d);
      outFile.close();
    } catch (Exception e) {
      System.out.println("Unable to write the output File: " + outFileName);
      System.err.println(e);
    }
    // Regular program termination message
    System.out.println("Done with io.java -- Good bye\n");
  }
}