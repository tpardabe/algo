package leetcode;

public class Problem141 {
    public boolean hasCycle(ListNode head) {
        return recurse(head, false);
    }

    public boolean recurse(ListNode head, boolean hasCycle) {
        if(head == null || hasCycle) return hasCycle;
        if(head.val ==  Integer.MIN_VALUE) hasCycle = true;
        return recurse(head.next, hasCycle);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
