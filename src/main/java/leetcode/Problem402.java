package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem402 {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack();
        for(int i =0; i < num.length(); i++) {
            int current = num.charAt(i) -'0';
            while(!stack.isEmpty() && k > 0 && stack.peek() > current) {
                stack.pop();
                k--;
            }
            if(stack.isEmpty() && current == 0);
            else stack.push(current);
        }
        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()) {
            int number = stack.pop();
            if(k < 1 ) builder.append(number);
            --k;
        }
        if(builder.toString().isEmpty()) builder.append("0");
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Problem402 problem402 = new Problem402();
        problem402.solve();
    }

    public void solve() {
        List<Pair> list = new ArrayList<>();
        list.add(new Pair("1432219", 3));
        list.add(new Pair("10200", 1));
        list.add(new Pair("22222", 2));
        list.add(new Pair("2341", 2));
        list.add(new Pair("23332", 2));
        list.add(new Pair("11000", 2));
        list.add(new Pair("10", 2));
        list.add(new Pair("12345", 2));
        for(Pair pair: list) {
            String result = removeKdigits(pair.val, pair.k);
            System.out.println(pair.val + "||" + result);
        }
    }
    class Pair{
        int k;
        String val;
        Pair(String val, int k) {
            this.k = k;
            this.val = val;
        }
    }
}
