package leetcode;

import java.util.Stack;

public class Problem856 {
    int currentIndex = 0;
    public int scoreOfParentheses(String S) {
        if(S.isEmpty()) return 0;
        currentIndex = 0;
        Stack<Character> stack = new Stack<>();
        Pair pair = recurse(stack, S, 0);
        return pair.val;
    }

    Pair recurse(Stack<Character> stack, String string, int cOpen){
        if(currentIndex == string.length()) return null;
        int multiplier = 0;
        int sum = 0;
        //base case???
        while (currentIndex < string.length() &&string.charAt(currentIndex) == '('){
            stack.push(string.charAt(currentIndex++));
            Pair pair = recurse(stack, string, cOpen +1);
            sum = sum + pair.val * pair.mul;

        }
        Pair pair = new Pair();
        if(!stack.isEmpty()) {
            stack.pop();
            pair.val = (sum == 0) ? 1 : sum;
            pair.mul = (sum == 0) ? 1 : 2;
        } else pair.val = sum;
        currentIndex++;
        return pair;
    }

    class Pair {
        public int val;
        public int mul;
    }

    public static void main(String[] a) {
        Problem856 problem856 = new Problem856();
        problem856.solve();
    }
     void solve() {
         System.out.println(scoreOfParentheses("(())()(())"));
     }
}
