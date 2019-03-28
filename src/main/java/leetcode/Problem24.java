package leetcode;
public class Problem24 {

    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        int count = 0;
        ListNode previous = null;
        ListNode result = null;
        ListNode resultPrevious = null;
        while(head != null) {
            count++;
            ListNode current = head;
            if(count%2 == 0) {
                if(count == 2) result = current;
                else resultPrevious.next = current;
                ListNode tmp = current.next;
                current.next = previous;
                previous.next = tmp;
                head = previous.next;
                resultPrevious = previous;

            } else {
                previous = current;
                head = head.next;
            }

        }
        if(count == 1) result = previous;
        return result;
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
