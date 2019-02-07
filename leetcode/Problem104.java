package leetcode;

public class Problem104 {
    public static void main(String[] args) {
        Problem104 problem104 = new Problem104();
        problem104.solve();
    }
    public void solve(){
        TreeNode p = new TreeNode(3);

        TreeNode left1 = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        p.left = left1;

    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int right = maxDepth(root.right);
        int left = maxDepth(root.left);
        return 1 + Math.max(right, left);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
