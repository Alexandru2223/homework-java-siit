package tema10;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci {


    public static List<Long> getFib() {
        long[] longs = {0,1};
         List<Long> fibValues = Stream.iterate(longs, x -> new long[]{x[1], x[0] + x[1]})
                                   .limit(10)
                                   .map(x -> x[0])
                                   .collect(Collectors.toList());
         return fibValues;
    }
}
