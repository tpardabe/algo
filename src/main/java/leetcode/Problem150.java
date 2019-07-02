package leetcode;

import java.util.Stack;

public class Problem150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+")) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(x +y);
            } else if(tokens[i].equals("-")) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y - x);
            } else if(tokens[i].equals("*")) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y * x);
            } else if(tokens[i].equals("/")) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y / x);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
