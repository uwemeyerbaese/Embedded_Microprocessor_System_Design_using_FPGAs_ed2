// Drawing squares and circles in random color
// at random locations

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.Random;
import javax.swing.JFrame;

public class NoOpenCV {

  public static class RectsOvalsJPanel extends JPanel {
    // display various rectangles and ovals
    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      this.setBackground(Color.CYAN);
      Random r = new Random(0);
      int N = 256, D = 40;
      g.setColor(Color.BLACK); // Plot box in black
      g.fillRect(0, 0, N, N);
      g.setColor(Color.WHITE); // Text in white
      g.drawString("Image Demo (no OpenCV)", 80, 20);
      for (int i = 0; i < 10; i++) {
        // Same random color for square and circle but different locations
        g.setColor(new Color(r.nextFloat(), r.nextFloat(), r.nextFloat()));
        g.fillRect(r.nextInt(N - D), r.nextInt(N - D), D, D); // Draw filled square
        g.fillOval(r.nextInt(N - D), r.nextInt(N - D), D, D);  // Draw filled circle
      }
    }
  }

  // execute application
  public static void main(String[] args) {
    // create frame for RectsOvalsJPanel
    JFrame frame = new JFrame("Draw [] and O ");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    RectsOvalsJPanel RectsOvalsJPanel = new RectsOvalsJPanel();
    RectsOvalsJPanel.setBackground(Color.WHITE);
    frame.add(RectsOvalsJPanel);
    frame.setSize(300, 320);
    frame.setVisible(true);
  }
}