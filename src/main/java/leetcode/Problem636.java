package leetcode;

import java.util.List;
import java.util.Stack;

public class Problem636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs.size() == 0) return null;
        int[] result = new int[n];
        String start = "start";
        Stack<Integer> stack = new Stack<>();
        Stack<Pair> done = new Stack<>();
        for(String s: logs) {
            String[] current = s.split(":");
            if(current[1].equals(start)) {
                stack.push(Integer.parseInt(current[2]));
            } else {
                int functionId = Integer.parseInt(current[0]);
                int endTime = Integer.parseInt(current[2]);
                int startTime = stack.pop();
                int time = 0;
                while (!done.isEmpty() && done.peek().endTime < endTime && done.peek().endTime > startTime) {
                    time +=done.pop().time;
                }
                int functionTime = (endTime - startTime) +1 - time;
                result[functionId] += functionTime;
                if(!stack.isEmpty()) {
                    done.push(new Pair(endTime, functionTime + time));
                }
            }
        }
        return result;
    }

    class Pair {
        int endTime;
        int time;
        Pair(int endTime, int time) {
            this.endTime = endTime;
            this.time = time;
        }
    }
}
