import java.io.*; // System I/O and exceptions

public class pingOS {
  public static void main(String[] args) {
    String url = "www.example.org";
    String command = "ping -c 4  " + url; // request 4 packages from random address
    try {
      Process process = Runtime.getRuntime().exec(command); // exec OS instructions
      BufferedReader reader = new BufferedReader(
              new InputStreamReader(process.getInputStream()));
      String line;
      while ((line = reader.readLine()) != null) {
          System.out.println(line);
      }
      reader.close();
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Sorry, URL: " + url + " failed !!!");
        }
  }
}
