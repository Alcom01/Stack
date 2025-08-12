# Problem
## Valid Parentheses
Solved
You are given a string s consisting of the following characters: `'('`,`')'` `'{'`, `'}'`, `'['` and `']'.`

The input string `s` is valid if and only if:

Every open bracket is closed by the same type of close bracket.
Open brackets are closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
Return ***true*** if `s` is a valid string, and ***false*** otherwise.


## Solution
We can easily solve this problem by using *Stack*,
All we need to do is find valid pairs that satisfies our condition above
1) First of all , we need to create stack object to hold our opening brackets
2) After creating our stack we need make sure `length` of given  String `s` has to be greater than 2(since for at least  opening bracket you have to have one corresponding closing bracket.)
3) After that we have to loop through our string and check each character
 -  if character at index is opening bracket, push it onto stack.
 -  if character at index is closing bracket, check for corresponding opening bracket at the top of stack, if we didn't find corresponding opening bracket it means there is no valid pair, immediately return false.
 - if character at index is closing bracket and  corresponding  opening bracket at the top our stack which means we found valid matching pair of brackets.
 -  And Then we  can pop the top value from our stack and move on to next character since we found valid pairs 
4) Finally, we have to if our stack is empty if it is empty it means all opening/closing values have their own valid pairs.

## Code Implementation
```java

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
```