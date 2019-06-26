package main.java.leetcode;

import java.util.Stack;

public class Problem394 {
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ']') {
                StringBuilder builder = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '[') {
                    builder.append(stack.pop());
                }
                stack.pop();
                int multplier = 0;
                int pow = 0;
                //finding multiplier
                while(!stack.isEmpty() && stack.peek() >='0' && stack.peek() <= '9') {
                    multplier = multplier + (int)Math.pow(10, pow) * ( stack.pop() -'0');
                    pow++;
                }
                String cur = builder.toString();
                builder = new StringBuilder();

                //multiplying
                for(int j=1;j <= multplier; j++) builder.append(cur);
                cur = builder.toString();
                //adding results to stack
                for(int j =cur.length() -1; j >= 0; j--) stack.push(cur.charAt(j));
            }
            else stack.push(s.charAt(i));
        }
       StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()) builder.append(stack.pop());
        return builder.reverse().toString();
    }
}
