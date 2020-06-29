package tema10tests;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static tema10.Exercise2.getMatch;

public class Exercise2Tests {
    @Test
    public void given_correct_input_when_check_if_it_is_correct(){
        String input = "()[]{}";
        boolean result = getMatch(input);
        assertTrue(result);
    }

    @Test
    public void given_wrong_input_when_check_if_it_is_incorrect(){
        String input = "([(]{}";
        boolean result = getMatch(input);
        assertFalse(result);
    }

    @Test
    public void given_null_input_when_check_if_it_is_null(){
        String input = null;
        boolean result = getMatch(input);
        assertFalse(result);
    }

    @Test
    public void given_empty_input_when_check_if_it_is_correct(){
        String input = "";
        boolean result = getMatch(input);
        assertTrue(result);
    }
}
