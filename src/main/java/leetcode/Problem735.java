package leetcode;

import java.util.Stack;

public class Problem735 {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(Integer n: asteroids) {
            while(!stack.isEmpty() && (stack.peek() > 0 && n < 0
                    && stack.peek() < (n * (-1)))) {
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek() > 0 && n < 0
                    && stack.peek() == (n * (-1))) stack.pop();
            else if(!stack.isEmpty()) ;
            else stack.push(n);
        }
        int[] result = new int[stack.size()];
        int i = stack.size()-1;
        while(!stack.isEmpty()) result[i--] = stack.pop();
        return result;
    }
}
