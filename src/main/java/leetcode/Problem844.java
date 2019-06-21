package leetcode;

import java.util.Stack;

class Problem844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack();
        Stack<Character> stack2 = new Stack();
        for(int i = 0; i < S.length(); i ++) {
            if(S.charAt(i) == '#') {
                if(!stack1.isEmpty()) stack1.pop();
            } else stack1.push(S.charAt(i));
        }
        for(int i =0; i < T.length(); i++) {
            if(T.charAt(i) == '#') {
               if(!stack2.isEmpty()) stack2.pop();
            } else stack2.push(T.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        while(!stack1.isEmpty()) {
            builder.append(stack1.pop());
        }
        String s1 = builder.toString();
        builder = new StringBuilder();
        while(!stack2.isEmpty()) {
            builder.append(stack2.pop());
        }
        return s1.equals(builder.toString());
    }
}
