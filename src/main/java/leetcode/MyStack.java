package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

class MyStack {
     Queue<Integer> queue;
    /** Initialize your data structure here. */
   public MyStack() {
        queue = new PriorityQueue<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queue.isEmpty()) return -1;
        int number = queue.poll();
        if(queue.isEmpty() ) return number;
        else {
            int res = pop();
            queue.add(number);
            return res;
        }
    }

    /** Get the top element. */
    public int top() {
        if(queue.isEmpty()) return -1;
        int number = queue.poll();
        if(queue.isEmpty() ) {
            queue.add(number);
            return number;
        } else {
            int res = top();
            queue.add(number);
            return res;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
