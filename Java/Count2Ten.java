public class Count2Ten implements Runnable {
  final private String mesg;
  final private int timeOut;

  public static void main(String[] argv) {
    final int N = 10; // Number of job to be created
    for (int k = 1; k <= N; k++) {
      Count2Ten thrd = new Count2Ten("Count2Ten: ", k);
    }
    System.out.println("All " + N + " threads generated.");
  }

  // The Count2Ten Constructor
  public Count2Ten(String m, int c) {
    timeOut = c;
    mesg = m;
    Thread t = new Thread(this);
    t.setName(m + " runner Thread");
    t.start();
  }

  @Override
  public void run() {
    try {
      Thread.sleep(timeOut * 1000L); // t * 1sec
    } catch (InterruptedException err) {
      System.out.println(err);
    }
    System.out.println(mesg + timeOut);
    if (timeOut == 10) System.out.println("DONE COUNTING");
  }
}
