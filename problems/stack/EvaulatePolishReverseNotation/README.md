# Problem
You are given an array of strings `tokens` that represents a valid arithmetic expression in `Reverse Polish Notation`.

Return the integer that represents the evaluation of the expression.

The operands may be integers or the results of other operations.
The operators include `'+'`, `'-'`, `'*'`, and `'/'`.
Assume that division between integers always  `truncates` toward zero.


## Solution
We can create a stack that will hold our integers  in string array `tokens`
if we encounter `operator` we are gonna pop two elements from our stack and apply that operator to elements 
and push that result to our stack 
Finally we are gonna return stack.pop() which will be final result.


## Code Implementation

```java
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

```
Author Alcom01