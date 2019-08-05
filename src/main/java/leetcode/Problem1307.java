package leetcode;

import java.util.Stack;

public class Problem1307 {
    /**
     * @param preorder: List[int]
     * @return: return a boolean
     */
  public boolean verifyPreorder(int[] preorder) {
        if(preorder == null) return true;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        Stack<Pair> stack = new Stack();
        stack.push(new Pair(0, min, max));
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            if(pair.currentIndex >= preorder.length -1) continue;
            else if(preorder[pair.currentIndex] < preorder[pair.currentIndex +1] && preorder[pair.currentIndex] > pair.min && preorder[pair.currentIndex] < pair.max) {
                stack.push(new Pair(pair.currentIndex + 1, preorder[pair.currentIndex], pair.max));
            } else if(preorder[pair.currentIndex] > preorder[pair.currentIndex +1]) {
                if(preorder[pair.currentIndex +1] < pair.min) return false;
                boolean checkRight = (pair.currentIndex +2 < preorder.length && preorder[pair.currentIndex] < preorder[pair.currentIndex +2]) ? true : false;
                if(checkRight) {
                    stack.push(new Pair(pair.currentIndex*2 + 1, pair.min, preorder[pair.currentIndex]));
                    stack.push(new Pair(pair.currentIndex + 2, preorder[pair.currentIndex], pair.min));
                } else {
                    stack.push( new Pair(pair.currentIndex + 1, pair.min, preorder[pair.currentIndex]));
                }
            }
        }
        return true;
    }

    class Pair {
        int currentIndex;

        public Pair(int currentIndex, int min, int max) {
            this.currentIndex = currentIndex;
            this.min = min;
            this.max = max;
        }

        int min;
        int max;
    }
}
