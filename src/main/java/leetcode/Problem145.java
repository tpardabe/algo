package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack  = new Stack();
        Stack<Integer> value = new Stack();
        Stack<Integer> counter = new Stack<>();
        List<Integer> result = new ArrayList();
        boolean isLeft = true;
        while(root !=null || !stack.isEmpty()) {
            while(root != null) {
                if(!isLeft && !counter.isEmpty()) {
                    counter.push(counter.pop() + 1);
                } else counter.push(1);
                stack.push(root);
                root = root.left;
                if(root != null) isLeft = true;
            }
            TreeNode tmp = stack.pop();
            value.add(tmp.val);
            if(tmp.right == null) {
                int size = counter.pop();
                while (!value.isEmpty() && size-- > 0) {
                    result.add(value.pop());
                }
            }
            root = tmp.right;
            if(root != null) isLeft = false;
        }
        while(!value.isEmpty()) result.add(value.pop());
        return result;
    }


    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Problem145 problem145 = new Problem145();
        problem145.solve();
    }
    void solve() {
       TreeNode root = new TreeNode(3);
       root.left = new TreeNode(4);
       root.left.right = new TreeNode(2);
       root.left.right.right = new TreeNode(1);
        List<Integer>  res = postorderTraversal(root);
        for (Integer integer : res) {
            System.out.println(integer);
        }
    }
}
