
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public static void main(String[] args) {
    String s = "[]";
    String t = "([{}])";
    String l = "[(])";
    String k = "]]";
    String m = "";
    String o = "[([{}])]";

    // intuitive solution
    System.out.println("-------------------------------------");
    System.out.println(" Simple solution  by using enchanted for loop and basic if else");
    System.out.println(isValid(s));
    System.out.println(isValid(t));
    System.out.println(isValid(l));
    System.out.println(isValid(k));
    System.out.println(isValid(m));
    System.out.println(isValid(o));
}
private static boolean isValid(String s) {
    Stack<Character> charStack = new Stack<>();
    if (s.length() < 2) {
        return false;
    }
    for (char c : s.toCharArray()) {
        if (c == '[' || c == '(' || c == '{') {
            charStack.push(c);
        }
        if (c == ']') {
            if (charStack.isEmpty()) {
                return false;
            }
            if (charStack.peek() != '[') {
                return false;
            } else {
                charStack.pop();
            }
        }
        if (c == ')') {
            if (charStack.isEmpty()) {
                return false;
            }
            if (charStack.peek() != '(') {
                return false;
            } else {
                charStack.pop();
            }
        }
        if (c == '}') {
            if (charStack.isEmpty()) {
                return false;
            }
            if (charStack.peek() != '{') {
                return false;
            } else {
                charStack.pop();
            }
        }

    }
    return charStack.isEmpty();
}

