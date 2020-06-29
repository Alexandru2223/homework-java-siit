package tema10;

import java.util.Deque;
import java.util.LinkedList;

public class Exercise2 {

    public static boolean getMatch(String string) {
        if(string == null){
            return false;
        }
        Deque<Character> deque = new LinkedList<>();
        char[] chars = string.toCharArray();
        for (char x : chars) {
            if (x == '(' || x == '[' || x == '{') {
                deque.add(x);
            } else if (x == ')' || x == ']' || x == '}') {
                if (deque.isEmpty()) {
                    return false;
                }
                if (x == ')' && deque.peekLast() == '(' || x == ']' && deque.peekLast() == '[' || x == '}' && deque.peekLast() == '{') {
                    deque.removeLast();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return deque.isEmpty();
    }
}
