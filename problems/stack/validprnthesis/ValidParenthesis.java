package stack.validprnthesis;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args){
        String s = "[]";
        String t = "([{}])";
        String l = "[(])";
        String k = "]]";

       System.out.println(isValid(s));
       System.out.println(isValid(t));
       System.out.println(isValid(l));
       System.out.println(isValid(k));

    }



    private static boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();
         // if length of given string is less than two string cannot be valid since there won't be corresponding opening/closing bracket
         if(s.length() < 2){
             return false;
         }
         // converting String s to charArray for iterating through
        for( char c : s.toCharArray()){
            // check if character is c is opening bracket if it is, add it to our stack.
            if(c == '['  ||  c == '('  ||  c == '{'){
                stack.push(c);
            }
            // if  current character is closing brackets.
            if(c == ']'){
                // if our stack is empty it means there is no corresponding opening bracket.
                if(stack.isEmpty()){
                    return false;
                }
                // if character at the top our stack is not opening bracket return false
                if(stack.peek() != '['){
                    return false;
                }else{
                    // if character at the top our stack is opening bracket it means we found our valid pair of brackets, pop top value so we can move onto next bracket.
                    stack.pop();
                }
            }
            //if  current character is closing parenthesis.
            if(c == ')'){
                // if our stack is empty it means there is no corresponding opening bracket.
                if(stack.isEmpty()){
                    return false;
                }
                // if character at the top our stack is not opening parenthesis return false
                if(stack.peek() != '('){
                    return false;
                }else{
                    // if character at the top our stack is opening parenthesis it means we found our valid pair of brackets,pop the top value so we can move onto next bracket/parenthesis/curly brackets pairs.
                    stack.pop();
                }
            }
            //if  current character is closing curly bracket.
            if(c == '}'){
                // if our stack is empty it means there is no corresponding opening  curly bracket.
                if(stack.isEmpty()){
                    return false;
                }
                // if character at the top our stack is not opening curly brackets then return false
                if(stack.peek() != '{'){
                    return false;
                }else{
                    // if character at the top our stack is opening parenthesis it means we found our valid pair of curly brackets,pop the top value so we can move onto  check next bracket/parenthesis/curly brackets pairs.
                    stack.pop();
                }
            }
        }
        // if there is corresponding opening/closing pair for  bracket/ parenthesis/ curly brackets it'll leads to empty stack since we are removing each valid pair we found(by using stack.pop(
         return stack.isEmpty();
    }
}
