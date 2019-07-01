package leetcode;

import java.util.Stack;

public class Problem331 {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.isEmpty()) return false;
        Stack<String> stack = new Stack<>();
        int i = 0;
        boolean isLeft = true;
        String[] values = preorder.split(",");
        if(values.length == 1 && !values[0].equals("#")) return false;
        for(;i < values.length; ) {
            String currentChar = values[i++];
            stack.push(currentChar);
            if(currentChar.equals("#")) {
                isLeft = false;
                break;
            }
        }
        boolean valid = true;
        while(i < values.length && valid) {
            while(isLeft && i < values.length) {
                String currentChar = values[i++];
                stack.push(currentChar);
                if(currentChar.equals("#")) isLeft = false;
            }
            stack.pop();
            if(i < values.length) {
                String currentChar = values[i++];
                if(!currentChar.equals("#")) isLeft = true;
            }
            if(stack.isEmpty()) valid = false;

        }
        if(stack.size() != 1 || !valid) return false;
        else return true;
    }
}
