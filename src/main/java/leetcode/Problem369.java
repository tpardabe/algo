package leetcode;
public class Problem369 {
    /**
     * @param head: the first Node
     * @return: the answer after plus one
     */
   public ListNode plusOne(ListNode head) {
        // Write your code here
        int excess = recurse(head);
        if(excess > 0) {
            ListNode tmp = new ListNode(excess);
            tmp.next = head;
            head =  tmp;
        }
        return head;
    }
    
    private int recurse(ListNode head) {
        if(head == null) return 0;
        int excess = recurse(head.next);
        int sum = 0;
        if(head.next == null) sum = head.val +1;
        else sum =  head.val + excess;
        head.val = sum %10;
        return sum/10;
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
