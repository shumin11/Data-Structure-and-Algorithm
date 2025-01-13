import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ValidParenthese {
    
    public static boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2  == 1) return false;
        Stack<Integer> stackLocked = new Stack<>();
         Stack<Integer> stackUnlocked = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1' && s.charAt(i) == '(') {
                stackLocked.add(i);
            } else if (locked.charAt(i) == '0') {
                stackUnlocked.add(i);
            } else {
                if (!stackLocked.isEmpty()) {
                    stackLocked.pop();
                } else if (!stackUnlocked.isEmpty()) {
                    stackUnlocked.pop();
                } else{
                    return false;
                }
            }
        }
        while (!stackLocked.isEmpty() && !stackUnlocked.isEmpty() && stackLocked.peek() < stackUnlocked.peek()) {
            stackLocked.pop();
            stackUnlocked.pop();
        }
        if (!stackLocked.isEmpty()) return false;
        return true;
    }
    public static void main(String[] args) {
        String s = "(()())";
        String locked = "010101";
        System.out.println("Result: " + canBeValid(s, locked));              
    }
}