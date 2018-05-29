package leetcode;

import javafx.util.Pair;

public class Problem83 {

    public static void main(String[] args) {
        Problem83 problem83 =  new Problem83();
        problem83.solve();
    }

    public void solve() {
        ListNode node  = new ListNode(1);
        ListNode node1 = new ListNode(1);
        node.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;

        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        node2.next = node3;
        node3.next = node4;


        ListNode result = deleteDuplicates(node);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode result = new ListNode(head.val);
        ListNode current = result;
        int previousVal = head.val;
        ListNode next = head.next;
        while (next != null) {
            if(previousVal != next.val) {
                ListNode tmp = new ListNode(next.val);
                current.next = tmp;
                current = current.next;
            }
            previousVal= next.val;
            next = next.next;
        }
        return result;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
