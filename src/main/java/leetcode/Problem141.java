package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem141 {
    public boolean hasCycle(ListNode head) {
        return recurse(head, false);
    }

    public boolean recurse(ListNode head, boolean hasCycle) {
        if(head == null || hasCycle) return hasCycle;
        if(head.val ==  Integer.MIN_VALUE) hasCycle = true;
        return recurse(head.next, hasCycle);
    }
    public boolean hasCycle1(ListNode head) {
        Set set = new HashSet();
        boolean hasCycle = false;
        while(head != null && !hasCycle) {
            if(set.contains(head)) hasCycle = true;
            set.add(head);
            head = head.next;
        }
        return hasCycle;
    }
    public boolean hasCycle2(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != null && fast != null) {
            if(slow == fast) return true;
            slow = slow.next;
            fast = fast.next;
            if(fast != null) fast = fast.next;
        }
        return false;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
