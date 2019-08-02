package leetcode;

import java.util.Stack;

public class Problem224 {

    public static int calculate(String s) {
        if(s.isEmpty()) return 0;
        s = s.replaceAll("\\s","");
        Stack<String> stack = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int endIndex = s.length();
        int i = s.length() - 1;
        for( ; i >=0; i--) {
            char current  = s.charAt(i);
            if(current == '(') {
                if(endIndex != i + 1) stack.push(s.substring(i+1, endIndex));
                endIndex = i;
                int total = Integer.valueOf(stack.pop());
                while(operators.peek() != ')') {
                    String number2 = stack.pop();
                    total = (operators.pop() == '+') ? total + Integer.valueOf(number2) : total - Integer.valueOf(number2);
                }
                operators.pop();
                stack.push(String.valueOf(total));
            } else {
                if(current == '+') {
                    if(endIndex != i + 1) stack.push(s.substring(i+1, endIndex));
                    operators.push(current);
                    endIndex = i;
                } else if(current == '-'){
                    if(endIndex != i + 1) stack.push(s.substring(i+1, endIndex));
                    operators.push(current);
                    endIndex = i;
                } else if(current == ')') {
                    operators.push(current);
                    endIndex = i;
                }
            }
        }
        if(endIndex != i +1 && i +1 < endIndex) {
            stack.push(s.substring(i+1, endIndex));
        }
        int sum = 0;
        if(!stack.isEmpty()) {
            sum = Integer.valueOf(stack.pop());
        }
        while(!stack.isEmpty()) {
            String number = stack.pop();
            sum = (operators.pop() == '+') ? sum + Integer.valueOf(number) : sum - Integer.valueOf(number);
        }
        return sum;
    }
}
