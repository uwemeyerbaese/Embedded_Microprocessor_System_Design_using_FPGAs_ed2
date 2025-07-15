// Clock example with date, time, and location
import java.awt.*; // Used for GUI blocks
import java.awt.event.*; // Needed Listener
import java.time.*; // Methods to get system time

class ClockDesign extends Frame {
  Label timeLabel, zoneLabel;

  public ClockDesign() {
    setLayout(new GridLayout(0, 1, 5, 0)); // 1 column; infinity rows
    setTitle("UMB Clock");
    ZonedDateTime zdt = ZonedDateTime.now();
    System.out.println(zdt);
    zoneLabel = new Label(String.format("Date and Time for  %s is\n", zdt.getZone()));
    zoneLabel.setBackground(Color.YELLOW);
    add(zoneLabel);
    timeLabel = new Label("");
    timeLabel.setBackground(Color.CYAN);
    add(timeLabel);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    setSize(250, 80);
    setVisible(true);

    while (true) { // Run infinity loop
      zdt = ZonedDateTime.now();
      String str2 = String.format("%s %d, %d at %02d:%02d:%02d   %n", zdt.getMonth(),
        zdt.getDayOfMonth(), zdt.getYear(), zdt.getHour(), zdt.getMinute(), zdt.getSecond());
      timeLabel.setText(str2);
      try {
        Thread.sleep(500);  // Display new time every 500ms
      } catch (InterruptedException e) {
        System.out.println(e);
      }
    }
  }

  public static void main(String[] args) {
    new ClockDesign();
  }
}