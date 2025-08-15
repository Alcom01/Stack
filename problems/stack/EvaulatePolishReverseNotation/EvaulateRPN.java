package stack.EvaulatePolishReverseNotation;

import java.util.Stack;

public class EvaulateRPN{
    public static void main(String[] args){
        String[] tokens1 = {"1","2","+","3","*","4","-"};
        String[] tokens2 = {"2","1","+","3","*"};
        String[] tokens3 = {"1","2", "-","3","+"};
        String[] tokens4 = {"4","13","5","/","+"};
        String[] tokens5 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int res1 = evalRPN(tokens1);
        int res2= evalRPN(tokens2);
        int res3= evalRPN(tokens3);
        int res4 = evalRPN(tokens4);
        int res5 = evalRPN(tokens5);


        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        System.out.println(res5);
    }

    private static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String s : tokens){
            // check for operators
            if(s.equals("+")){
                stack.push(stack.pop() + stack.pop());
                 // add two elements before operator and push the result to the stack.

            }else if(s.equals("-")){
                int b = stack.pop(); // get second element
                int a = stack.pop();  // get first element.
                stack.push(a -b);
                // subtract two elements before occurrence of operator and push the result to the stack.

            }else if(s.equals("*")){
                stack.push(stack.pop() * stack.pop());
                //  multiply two elements before "*" operator and push the result to the stack.

            }else if(s.equals("/")){
                int b = stack.pop(); // get second eleemnt
                int a = stack.pop(); // get first
                //  multiply two elements before "*" operator and push the result to the stack.
                stack.push(a / b); // integer division.
            }else{
                stack.push(Integer.parseInt(s));
            }

        }
        return stack.pop();
    }
}
