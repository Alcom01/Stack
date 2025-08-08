package stack.killmonsters;

import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class KillMonsters {
    public static void main(String[] args) {
       int[] monsters1 = {3,0,3,4,1};
       int[] monsters2 =  {5,4,3,2,1};

        String numOfAliveMonsters1 = killMonsters(monsters1);
        String numOfAliveMonsters2 = killMonsters(monsters2);
        System.out.println(numOfAliveMonsters1);
        System.out.println(numOfAliveMonsters2);
     }

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


}