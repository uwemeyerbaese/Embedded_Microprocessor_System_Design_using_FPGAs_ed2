// SortTime.java
// Computing performance of Arrays sort.

//import java.time.*; // Methods to get system time // Not in SE6
import java.util.Random; // Random number generation with seeds
import java.util.Arrays; // Array class method used for sort

public class SortTime {
  public static void main(String[] args) {
    // Create array of N random values, then copy it
    //final int N = 1_000_000; // not in SE6
    final int N = 1000000;
    Random randomNumbers = new Random(0);
    double[] arr = new double[N];
    //Arrays.setAll(arr, i -> randomNumbers.nextDouble());
    for (int k = 0; k < N; k++)
      arr[k]= randomNumbers.nextDouble();

    // Time sorting of arr with Arrays method sort
    System.out.println("*** Computing STD sort");
    //Instant sortStart = Instant.now();
    long sortStart = System.currentTimeMillis();
    Arrays.sort(arr);
    //Instant sortEnd = Instant.now();
    long sortEnd = System.currentTimeMillis();

    // Display timing results
    //long sortTime = Duration.between(sortStart, sortEnd).toMillis();
    long sortTime = sortEnd - sortStart;
    System.out.println("Start Time was:" + sortStart);
    System.out.println("Stop  Time was:" + sortEnd);
    System.out.printf("Total 1M standard sort time: %d ms\n", sortTime);
    System.out.printf("First value = %e; last value = %e\n", arr[0], arr[N - 1]);
  }
}

