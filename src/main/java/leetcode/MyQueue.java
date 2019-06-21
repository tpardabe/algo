package leetcode;

import java.util.Stack;

class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stack = null;
    public MyQueue() {
        stack = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(x);
            return;
        }
        int number = stack.pop();
        push(x);
        stack.push(number);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       if(stack.isEmpty()) return -1;
        int number = stack.pop();
        return number;
    }
    
    /** Get the front element. */
    public int peek() {
        if(stack.isEmpty()) return -1;
        int number = stack.pop();
        stack.push(number);
        return number;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
