package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Problem144 {
    public List<Integer> preorderTraversal(TreeNode root) {
      Stack<TreeNode> stack = new Stack();
        List<Integer> list = new ArrayList<>();
        while(root != null) {
            list.add(root.val);
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
                if(root != null) list.add(root.val);
            }
            root = stack.pop();
            root = root.right;
            if(root != null) list.add(root.val);
        }
        return list;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
