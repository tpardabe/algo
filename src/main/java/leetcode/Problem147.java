package leetcode;
public class Problem147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode sentinental = new ListNode(Integer.MAX_VALUE);
        sentinental.next = head;
        ListNode current = head;
        int counter = 0;
        while(current != null) {
            ListNode curHead = sentinental.next;
            ListNode prev = sentinental;
            int pointer = 1;
            ListNode next = null;
            boolean found = false;
            counter++;
            while(curHead != null && pointer < counter) {
                pointer++;
                if(current.val < curHead.val && !found) {
                    next = current.next;
                    prev.next = current;
                    current.next = curHead;
                    found = true;
                }
                prev = curHead;
                curHead = curHead.next;
            }
            if(found ) {
                prev.next = next;
                current = prev;
            }
            current = current.next;
        }
        return sentinental.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
