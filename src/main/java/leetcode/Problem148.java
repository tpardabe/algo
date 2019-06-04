package leetcode;
public class Problem148 {
    public ListNode sortList(ListNode head) {
        ListNode sentinel = new ListNode(Integer.MIN_VALUE);
        sentinel.next = head;
        recurse(sentinel, head, head);
        return sentinel.next;
    }
    
    public void recurse(ListNode prev, ListNode slow, ListNode fast) {
        ;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
