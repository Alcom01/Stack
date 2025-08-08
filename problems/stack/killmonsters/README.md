# Problem
Given an array
denoting strengths of
monsters, we start with an empty battlefield, at each minute *i*, the *ith*
monster joins the battlefield and kills all monsters whose strength is less than or equal to his strength.
Find the number of monsters alive in the battlefield at end of
minute for each
.

## Solution
We can solve this using a **stack** to track survivors:
- Create a stack `survivors` to store the monsters currently alive.
- For each incoming monster:
    - While the stack is not empty **and** the top monster’s strength is less than or equal to the incoming monster’s strength:
        - Pop (remove) the weaker monster from the stack.
    - Push the current monster onto the stack.
- The stack will now contain only the survivors at the end.
  
## Code implementation
```java
private static String killMonsters(int[] monsters) {
        Stack<Integer> survivors = new Stack<>();
        survivors.push(monsters[0]); // our first monster

           for(int i = 1; i < monsters.length; i++){
               while(!survivors.isEmpty() && survivors.peek() <= monsters[i]){
                          survivors.pop(); // kill the weak monster(keep killing them until stack is empty or find equal or greater opponent.
                   }
                survivors.push(monsters[i]); //
           }
        return survivors.toString();
    }

````
Author Alcom01