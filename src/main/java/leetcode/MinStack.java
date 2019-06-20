package leetcode;
class MinStack {

    /** initialize your data structure here. */
   LinkedList list;
    int min;
    public MinStack() {
        list = new LinkedList();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        list.addFirst(x);
        if(min > x) min = x;
    }

    public void pop() {
        int num = (int)list.removeFirst();
        if(num == min) {
            Iterator it = list.iterator();
            if(!list.isEmpty()) min = (int)list.getFirst();
            else  min = Integer.MAX_VALUE;
            while(it.hasNext()){
                int number = (int)it.next();
                if(min > number) min = number;
            }
        }
    }

    public int top() {
        return (int)list.getFirst();
    }

    public int getMin() {
        return min;
    }
}
