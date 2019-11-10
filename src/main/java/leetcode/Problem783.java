package leetcode;

class Problem783 {
    public int minDiffInBST(TreeNode root) {
        return bst(root, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    
    int bst(TreeNode root, int min, int rootVal) {
        if(root == null) return min;
        int cur = Math.abs(root.val - rootVal);
        int curMin = Math.min(cur, min);
        int left = bst(root.left, curMin, root.val);
        int right = bst(root.right, curMin, root.val);
        return Math.min(left, right);
    }
}
