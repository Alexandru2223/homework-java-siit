package tema10tests;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static tema10.Fibonacci.getFib;

public class FibonacciTests {
    @Test
    public void shouldReturnFirst10FibonacciNumbers(){
        List<Long> value = List.of(0L,1L,1L,2L,3L,5L,8L,13L,21L,34L);
        List<Long> result = getFib();
        assertThat(value,is(equalTo(result)));
    }
}
