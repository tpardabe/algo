package leetcode;

public class Problem708 {
    public ListNode insert(ListNode node, int x) {
        // write your code here
        ListNode newNode = new ListNode(x);
        if(node == null) {
            newNode.next = newNode;
            return newNode;
        }
        boolean inserted = false;
        ListNode root = node;
        ListNode prev = null;
        ListNode greatest = new ListNode(Integer.MIN_VALUE);
        ListNode smallest = new ListNode(Integer.MAX_VALUE);
        while(!inserted) {
            if(root.val < smallest.val || (prev != null && prev.val > smallest.val && smallest.val == root.val)) smallest = root;
            if(root.val > greatest.val || (prev!= null && node != root && prev.val == greatest.val && (root.val > root.next.val || smallest.val == greatest.val))) greatest = root;
            if(prev != null && ((prev.val < x && root.val > x) || (prev.val <= x && root.val > x))) {
                prev.next = newNode;
                newNode.next = root;
                inserted = true;
            } else if(prev != null && node == root) {
                greatest.next = newNode;
                newNode.next = smallest;
                inserted = true;
            }
            prev = root;
            root = root.next;
        }
        return newNode;
    }

    public static void main(String[] args) {
        Problem708 problem708 = new Problem708();
        problem708.solve();
    }

    private void solve(){
        ListNode root = new ListNode(10);
        root.next = new ListNode(10);
        root.next.next = new ListNode(10);
        root.next.next.next = new ListNode(10);
        root.next.next.next.next = root;
        ListNode insert = insert(root, 9);
        while(root != null){
            System.out.println(root.val);
            if(root == insert) break;
            root = root.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
