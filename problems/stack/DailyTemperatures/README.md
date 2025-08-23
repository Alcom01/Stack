# Problem

You are given an array of integers `temperatures` where `temperatures[i]` represents the daily temperatures on the 
`ith` day.

Return an array `result` where `result[i]` is the number of days after the `ith` day before a warmer temperature appears on a future day. If there is no day in the future where a warmer temperature will appear for the `ith` day, set `result[i]` to `0` instead.
## Solution
We use a monotonic decreasing stack to keep track of indices of days whose warmer temperature hasn’t been found yet.

For each day, while the `current temperature` is warmer than the temperature at the index on top of the stack, we pop that index and record the difference in days.

Then, we push the current day onto the stack.

Days left in the stack never find a warmer day, so their result stays 0.

This way, it’s `O(n)` since each index is pushed and popped at most once


## Code Implementation
```java

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

```

Author Alcom01