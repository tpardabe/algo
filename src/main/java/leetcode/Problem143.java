package leetcode;

public class Problem143 {
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode sentinel = new ListNode(Integer.MAX_VALUE);
        sentinel.next = head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != null && fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        boolean[] found = new boolean[1];
        ListNode tail = recurse(head, slow, found, null);
        ListNode start = sentinel.next;
        ListNode current = sentinel;
        while(tail != null) {
            ListNode startNext = start.next;
            ListNode tailNext = tail.next;
            if(start != tail) {
                current.next = start;
                start.next = tail;
                current = tail;
            }
            start = startNext;
            tail = tailNext;
        }
        if(start == slow) {
            current.next = start;
            start.next = null;
        }
    }

    private ListNode recurse( ListNode head, ListNode breakable, boolean[] found, ListNode tail) {
        if(head == null) return tail;
        ListNode next = head.next;
        ListNode retVal  = recurse( next, breakable, found, head);
        if(head == breakable) {
            found[0] = true;
            if(next != null) next.next = null;
            head.next = null;
        }
        if(!found[0] && next != null) next.next = head;
        return retVal;
    }
    public static void main(String[] args) {
        Problem143 sol = new Problem143();
        sol.solve();
    }

    private void solve(){
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        reorderList(root);
        while(root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
