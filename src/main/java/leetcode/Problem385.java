package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem385 {
    public NestedInteger deserialize(String s) {
        int startIndex = 0;
        Stack<NestedInteger> stack =  new Stack<>();
        boolean closed = false;
        NestedInteger result = null;
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(current == '[') {
                NestedInteger tmp = new NestedInteger();
                if(!stack.isEmpty() && !stack.peek().isInteger()) stack.peek().add(tmp);
                stack.push(tmp);
                closed = false;
                startIndex = i + 1;
            } else if(current == ']') {
                result = stack.pop();
                if((!closed || (i > 0 && s.charAt(i-1) != ']')) && startIndex != i) result.add(new NestedInteger(Integer.valueOf(s.substring(startIndex, i))));
                closed = true;
            } else if(current == ',' ) {
                if(s.charAt(i-1) != ']') {
                    if(stack.isEmpty())
                        stack.push(new NestedInteger(Integer.valueOf(s.substring(startIndex, i))));
                    else
                        stack.peek().add(new NestedInteger(Integer.valueOf(s.substring(startIndex, i))));
                }
                startIndex = i +1;
                closed = false;
            } else if(i == s.length()-1 && current != ']') {
                if(stack.isEmpty() || stack.peek().isInteger()) stack.push(new NestedInteger(Integer.valueOf(s.substring(startIndex, i+1))));
                else stack.peek().add(new NestedInteger(Integer.valueOf(s.substring(startIndex, i+1))));
            }
        }

        while(!stack.isEmpty()) result = stack.pop();
        return result;
    }

    public class NestedInteger {
      // Constructor initializes an empty nested list.
        List<NestedInteger> list;
        Integer value;
        public NestedInteger(){
            list = new ArrayList<>();
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value){
          this.value = value;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger(){
            return (this.value != null) ? true : false;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return this.value;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value){
            this.value = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni){
            list.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList(){
            return list;
        }
    }
}
