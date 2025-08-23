package stack.DailyTemperatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DailyTemp {
    public static void main(String[] args) {
        int[] dailyTemperatures1 = {30, 38, 30, 36, 35, 40, 28};
        int[] dailyTemperatures2 = {22, 21, 20};

        int[] result = dailyTemperaturesWStack(dailyTemperatures1);
        int[] result2 = dailyTemperaturesWStack(dailyTemperatures2);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
    }

    // Brute Force
    private static int[] dailyTemperatures(int[] dailyTemperatures1) {
        int[] result = new int[dailyTemperatures1.length];

        for (int i = 0; i < dailyTemperatures1.length; i++) {
            for (int j = i + 1; j < dailyTemperatures1.length; j++) {
                if (dailyTemperatures1[i] < dailyTemperatures1[j]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    // Time & Space efficient solution

    private static int[] dailyTemperaturesWStack(int[] dailyTemperatures){
        int[] result = new int[dailyTemperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int currDay = 0;  currDay < dailyTemperatures.length; currDay++){
            while(!stack.isEmpty() && dailyTemperatures[currDay]  > dailyTemperatures[stack.peek()]){
                     result[stack.peek()] = currDay - stack.peek();
                     stack.pop();

            }
            stack.push(currDay);
        }
        return result;
    }
}


