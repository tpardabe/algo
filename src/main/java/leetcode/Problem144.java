package leetcode;
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
}
