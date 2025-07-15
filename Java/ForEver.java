import javax.swing.*;

public class ForEver {
  public static void main(String[] args) {
    System.out.println("This is a for ever loop:");
    int i = 0;
    int j = 0;
    while (i < 3) {
      String mssg = String.format("Debug Print: i=%d; j=%d", i, j);
      JOptionPane.showMessageDialog(null,
        mssg, "Attention", JOptionPane.INFORMATION_MESSAGE);
      System.out.println(mssg);
      j++;
    }
  }
}
