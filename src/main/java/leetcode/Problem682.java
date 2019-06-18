package leetcode;

import java.util.Stack;

public class Problem682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();
        int sum = 0;
        for(String s: ops) {
            if(s.equals("C")) {
                if(!stack.isEmpty()) stack.pop();
            } else if(s.equals("D")) {
                if(!stack.isEmpty()) stack.push(stack.peek() *2);
            } else if(s.equals("+")) {
                int num = stack.pop();
                int secNum = stack.peek();
                stack.push(num);
                stack.push(num + secNum);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        while(!stack.isEmpty()) {
            int num = stack.pop();
            sum += num;
        }
        return sum;
    }

}
