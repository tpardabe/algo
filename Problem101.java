package leetcode;

public class Problem101 {
    public static void main(String[] args) {
        Problem101 problem101 = new Problem101();
        problem101.solve();
    }
    public void solve(){
        TreeNode p = new TreeNode(1);

        TreeNode left1 = new TreeNode(2);
        left1.left = new TreeNode(3);
        left1.right = new TreeNode(4);
        p.left = left1;

        TreeNode right1 = new TreeNode(2);
        right1.right = new TreeNode(3);
        right1.left = new TreeNode(4);
        p.right = right1;
        System.out.println(isSymmetric(p));
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        else if(root.left == null && root.right == null) return true;
        else if(root.left == null || root.right == null) return false;
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode == null && rightNode == null) return true;
        else if(leftNode == null || rightNode == null) return false;
        boolean left = isSame(leftNode.left, rightNode.right);
        boolean right = isSame(leftNode.right, rightNode.left);
        if(leftNode.val != rightNode.val) return false;
        else if(!right || !left) return false;
        else return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
