package leetcode;
import java.util.Stack;

class Problem921 {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack();
        int result = 0;
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(') stack.push(S.charAt(i));
            else if(S.charAt(i) == ')' && !stack.isEmpty()) stack.pop();
            else result++;
        }
        while(!stack.isEmpty()) {
            stack.pop();
            result++;
        }
        return result;
    }
}
