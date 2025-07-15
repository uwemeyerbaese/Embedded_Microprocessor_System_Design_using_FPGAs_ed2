public class CountDown extends Thread {
  public static int count = 10;
  protected volatile boolean finished = false;

  @Override
  public void run() {
    while (!finished) {
      System.out.println("CountDown: " + count--);
      try {
        Thread.sleep(1000L);
      } catch (InterruptedException err) {
        System.out.println(err);
      }
    }
    System.out.println("LIFT OFF");
  }
  public void terminate() { finished = true;  }

  public static void main(String[] args)
    throws InterruptedException {
    CountDown thrd = new CountDown();
    thrd.start();
    Thread.sleep(10_000L);
    thrd.terminate();
  }
}
