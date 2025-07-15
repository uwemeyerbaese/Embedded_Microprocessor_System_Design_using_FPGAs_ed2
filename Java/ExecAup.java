// For the AUP image on TerasIC boards:
// cd /home/root/Linux_Libraries/drivers
// then ./load_drivers

import java.io.*; // System I/O and exceptions

public class ExecAup {
  public static void main(String[] args) {
    String line;
    String command = "cat /dev/IntelFPGAUP/SW"; // Used by AUP
    // String command = "gpio-demo -g 1003 -i"; // Used by myZed
    try {
      Process process = Runtime.getRuntime().exec(command); // exec OS instructions
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
