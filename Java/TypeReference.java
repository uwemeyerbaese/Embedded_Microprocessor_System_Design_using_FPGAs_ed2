import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TypeReference {
  public static void main(String[] args) {
    //System.out.println("*** Define <T> with 3 values:");
    int[] A = {1, 2, 3};
    List<Integer> L = Arrays.asList(1, 2, 3);
    Stream<Integer> SI = Stream.of(1, 2, 3);
    IntStream IS = IntStream.of(1, 2, 3);

    System.out.println("*** Print: ");
    System.out.println(Arrays.toString(A));
    System.out.println(L);
    System.out.println(Arrays.toString(SI.toArray()));
    System.out.println(Arrays.toString(IS.toArray()));

    //System.out.println("*** Convert from <T> to Stream:");
    IS = Arrays.stream(A);
    SI = Arrays.stream(A).boxed();
    SI = L.stream();
    IS = L.stream().mapToInt(Integer::intValue);

    //System.out.println("*** Convert from Stream to <T>:");
    L = SI.collect(Collectors.toList()); // SI.toList() in SE17
    L = IS.boxed().collect(Collectors.toList());
    //A = IS.toArray();
    //A = SI.mapToInt(x -> x).toArray();

    // Stream has already been operated upon or closed
//    IS = IntStream.of(1, 2, 3);
//    SI = Stream.of(1, 2, 3);
  }
}