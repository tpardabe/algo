package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem105 {
    public static void main(String[] args) {
        Problem105 problem105 =  new Problem105();
        problem105.solve();
    }

    public void solve(){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        List<List<Integer>> list = levelOrder(root);
        for(List i: list) {
            for(int j = 0; j < i.size(); j++) {
                System.out.print(i.get(j) + " ");
            }
            System.out.println();
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
      if(preorder.length == 0) return null;
        List<Integer> inorderList = new ArrayList<>();
        List<Integer> preorderList = new ArrayList<>();
        for(Integer i: inorder) inorderList.add(i);
        for(Integer i: preorder) preorderList.add(i);
        return build(preorderList, inorderList, 0, inorderList.size()-1);
    }

    private TreeNode build(List<Integer> preorder, List<Integer> inorder, int inorderLeftIndex, int inorderIndexRight) {
        //base case
        if(inorderLeftIndex > inorderIndexRight) return null;
        else if(preorder.isEmpty()) return null;
        int currentItem = preorder.get(0);
        TreeNode root = new TreeNode(currentItem);
        preorder.remove(0);
        int inorderIndex = 0;
        for(int j = inorderLeftIndex; j < inorder.size(); j++) {
            if(inorder.get(j) == currentItem) inorderIndex = j;
        }
        TreeNode left = build(preorder, inorder, inorderLeftIndex, inorderIndex-1);
        TreeNode right = build(preorder, inorder, inorderIndex+1, inorderIndexRight);
        root.left = left;
        root.right = right;
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        getLevel(root, list, 0);
        return list;
    }
    private void getLevel(TreeNode node, List<List<Integer>> list, int level) {
        if(node == null) return;
        if(list.size() <= level)
            list.add(level, new ArrayList<>());
        list.get(level).add(node.val);
        getLevel(node.left, list, level + 1);
        getLevel(node.right, list, level + 1);
    }
}
