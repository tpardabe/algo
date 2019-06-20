package leetcode;
class Problem739 {
    public int[] dailyTemperatures(int[] T) {
       Stack<Integer> stack = new Stack();
        int[] result = new int[T.length];
        int index = 0;
        for(int i = 0; i < T.length; i++) {
            result[i] = -1;
            index = i-1;
            if(stack.isEmpty()) stack.push(T[i]);
            else {
                while(!stack.isEmpty() && stack.peek() < T[i]) {
                    stack.pop();
                    boolean inserted = false;
                    while(!inserted) {
                        if(result[index] <0) {
                            inserted = true;
                            result[index] = i - index;
                        } else index--;
                    }
                }
                stack.push(T[i]);
            }
        }
        index  = T.length-1;
        while(!stack.isEmpty()) {
            stack.pop();
            boolean inserted = false;
            while(!inserted) {
                if(result[index] < 0) {
                    inserted = true;
                    result[index] = 0;
                } else index--;
            }
        }
        return result;
    }
}
