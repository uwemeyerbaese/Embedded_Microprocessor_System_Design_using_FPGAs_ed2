// Use for PetaLinux Xilinx boards
import java.io.*; // System I/O and exceptions

public class ExecGpio{
  public static void main(String[] args) {
    String line;
    String command = "gpio-demo -g 1003 -i"; // Used by myZed
    try {    // exec OS instructions
      Process process = Runtime.getRuntime().exec(command); 
      BufferedReader reader = new BufferedReader(
        new InputStreamReader(process.getInputStream()));
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Sorry, command " + command + " failed !!!");
    }
  }
}
