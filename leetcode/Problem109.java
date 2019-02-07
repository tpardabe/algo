class Problem109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        List<Integer> tmp = new ArrayList<Integer>();
        while (head != null) {
            tmp.add(head.val);
            head = head.next;
        }
        return traverse(tmp, 0, tmp.size()-1);
    }

    public TreeNode traverse(List<Integer> list, int left, int right) {
        if(left > right) return null;
        int middle = left + (right-left)/2;
        TreeNode root = new TreeNode(list.get(middle));
        root.left = traverse(list, left, middle-1);
        root.right  = traverse(list, middle+1, right);
        return root;
    }
}
