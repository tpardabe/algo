package leetcode;

public class Problem82 {

    public static void main(String[] args) {
        Problem82 problem82 =  new Problem82();
        problem82.solve();
    }

    public void solve() {
        ListNode node  = new ListNode(1);
        ListNode node1 = new ListNode(1);
        node.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
/*
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(3);
        node4.next = node5;
        node5.next = node6;*/


        ListNode result = deleteDuplicates(node);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode result = null;
        ListNode current = null;
        int previousVal = head.val;
        ListNode next = head.next;
        int numberOfOccurence = 1;
        while (next != null) {
            if(previousVal != next.val) {
                if(numberOfOccurence == 1) {
                    ListNode tmp = new ListNode(previousVal);
                    if(result == null) {
                        result = tmp;
                        current = result;
                    } else {
                        current.next = tmp;
                        current = current.next;
                    }
                }
                numberOfOccurence = 1;
            } else numberOfOccurence++;
            previousVal = next.val;
            next = next.next;
        }
        if(numberOfOccurence == 1) {
            ListNode tmp = new ListNode(previousVal);
            if(result == null) {
                result = tmp;
            } else {
                current.next = tmp;
            }
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
