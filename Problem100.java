package leetcode;

public class Problem100 {

    public static void main(String[] args) {
        Problem100 problem100 =  new Problem100();
        problem100.solve();
    }
    public void solve(){
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        System.out.println(isSameTree(p, q));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if(p == null || q == null) return false;
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        if(p.val != q.val) return false;
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



