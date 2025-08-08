package stack.reversestring;

import java.util.Stack;

public class ReverseStringWStack {

    public static void  main(String[] args){
        String s = "Stacking the Stacks";
        String t = "Im dying sister i got TB";
        String k = "cba";
        String l = "kayak";


        System.out.println(reverseString(s));
        System.out.println(reverseString(t));
        System.out.println(reverseString(k));
        System.out.println(reverseString(l));

    }

    private static String reverseString(String t) {
        Stack<Character> characterStack = new Stack<>(); // stack for holding characters at each index.

        // looping through to add each character to our stack.
         for(char c : t.toCharArray()){
             characterStack.push(c);

         }
         // Creating an empty string and popping elements from stack( since it'll pop from the top well start from end of the String t.
          StringBuilder reversedStr = new StringBuilder();

          for(int i = 0 ; i < t.length(); i++){
              reversedStr.append(characterStack.pop());
          }
          return reversedStr.toString();

    }
}
