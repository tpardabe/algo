package leetcode;

import java.util.Stack;
class Problem946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
       if(popped.length == 0) return true;
        Stack<Integer> stack = new Stack();
        boolean result = true;
        int j = 0;
        for(int i =0; i < pushed.length; i++) {
            while(!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
            stack.push(pushed[i]);
        }
         while(!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
            stack.pop();
            j++;
        }
        return (stack.isEmpty() && j == popped.length) ? true : false;
    }
}
