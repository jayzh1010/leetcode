package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Parentheses {
    public static boolean solute(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        char[] chars = s.toCharArray();
        for (Character c: chars) {
            if (map.containsValue(c)) {
                stack.push(c);
            } else if (map.containsKey(c)) {
                Character charInStack = stack.peek();
                if (charInStack.equals(map.get(c))) {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
