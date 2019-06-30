package leetcode;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    Deque<Integer> result;
    /*public NestedIterator(List<NestedInteger> nestedList) {
        int index = 0;
        List<NestedInteger> list = nestedList;
        result = new ArrayDeque<>();
        recurse(list);
    }

    private void recurse(List<NestedInteger> list) {
        for(NestedInteger integer: list) {
            if(integer.isInteger()) result.add(integer.getInteger());
            else recurse(integer.getList());
        }
    }*/

    public NestedIterator(List<NestedInteger> nestedList) {
        List<NestedInteger> list = nestedList;
        int index = list.size() - 1;
        result = new ArrayDeque<>();
        Stack<NestedInteger> stack = new Stack<>();
        while(!stack.isEmpty() || (list != null && index >= 0)) {
            if(list != null && index < list.size()) {
                stack.push(list.get(index++));
            } else {
                NestedInteger integer = stack.pop();
                if(integer.isInteger()) result.add(integer.getInteger());
                else {
                    list = integer.getList();
                    index = list.size() -1 ;
                }
            }
        }
    }

    @Override
    public Integer next() {
        return result.remove();
    }

    @Override
    public boolean hasNext() {
        return !result.isEmpty();
    }
     public interface NestedInteger {
 
              // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger();
 
              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();
 
              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return null if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
     }
 
}