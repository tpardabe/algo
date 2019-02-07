package leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class Problem20 {

    public static void main(String[] args) {
        Problem20 problem20 = new Problem20();
        System.out.println(problem20.isValid("{()[]}"));
    }

    public boolean isValid(String s) {
        if(s.isEmpty()) return true;
        else if(s.length() %2 != 0 ) return false;
        Stack<Character> stack= new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(current == '(') stack.push(current);
            else if(current == '{') stack.push(current);
            else if(current == '[') stack.push(current);
            else if(stack.empty()) return  false;
            else if(current == ')' && '(' == stack.pop()){ }
            else if(current == '}' && '{' == stack.pop()) {}
            else if(current == ']' && '[' == stack.pop()){ }
            else return false;
        }
        return stack.empty() ? true : false;
    }

}
