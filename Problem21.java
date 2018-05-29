package leetcode;

public class Problem21 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        if(l1 == null && l2 == null) return result;
        else if(l1 == null && l2 != null) return l2;
        else if(l2 == null && l1 != null) return l1;
        if(l1.val > l2.val) {
            result = new ListNode(l2.val);
            recursive(result, l1, l2.next);
        } else {
            result = new ListNode(l1.val);
            recursive(result, l1.next, l2);
        }
        return result;
    }
    public void recursive(ListNode result, ListNode left, ListNode right) {
        if(left == null && right == null) return;
        if(left == null){
            result.next = new ListNode(right.val);
            recursive(result.next, left, right.next);
        } else if(right == null) {
            result.next = new ListNode(left.val);
            recursive(result.next, left.next, right);
        } else if(left.val > right.val){
            result.next = new ListNode(right.val);
            recursive(result.next, left, right.next);
        } else {
            result.next = new ListNode(left.val);
            recursive(result.next, left.next, right);
        }
    }
}


