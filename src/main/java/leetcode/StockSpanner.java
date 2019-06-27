package leetcode;

import java.util.Stack;

class StockSpanner {
    Stack<Pair> maxStack;
    int size = 0;
    public StockSpanner() {
        size = 0;
        maxStack = new Stack<>();
    }

    public int next(int price) {
        size++;
        int max = Integer.MIN_VALUE;
        int counter = 1;
        while(!maxStack.isEmpty() && maxStack.peek().getVal() <= price) {
            if(max <= maxStack.peek().getVal()) {
                counter = size-1 - maxStack.peek().getIndex() + maxStack.peek().getCounter();
                max = maxStack.peek().getVal();
            }
            maxStack.pop();
        }
        Pair current = new Pair(price, counter, size -1);
        maxStack.push(current);
        return current.getCounter();
    }

    class Pair{
        public int getVal() {
            return val;
        }
        public int getCounter() {
            return counter;
        }
        int val;
        int counter;
        public int getIndex() {
            return index;
        }
        int index;
        Pair(int val, int counter, int index){
            this.val = val;
            this.counter = counter;
            this.index = index;
        }
    }
}
