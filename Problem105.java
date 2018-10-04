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
        List<Integer> list = new ArrayList<>();
        for(Integer i: inorder) list.add(i);
        return build(preorder, 0, list);
    }

    private TreeNode build(int[] preorder, int preOrderIndex, List<Integer> list) {
        if(preOrderIndex == preorder.length) return null;
        if(preOrderIndex > 0 && preorder[preOrderIndex- 1] == list.get(0)) {
            return null;//base case
        }
        TreeNode left = build(preorder, preOrderIndex + 1, list);
        TreeNode right = build(preorder, preOrderIndex + 1, list);
        TreeNode node = new TreeNode(preorder[preOrderIndex]);
        if(preorder[preOrderIndex] == list.get(0)) {
            list.remove(0);
        }
        node.left = left;
        node.right = right;
        return node;
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
