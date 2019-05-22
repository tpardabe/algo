package leetcode;

public class Problem876 {
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode tmpHead = head;
        while(tmpHead != null) {
            length++;
            tmpHead = tmpHead.next;
        }
        int middle = (length %2 == 1) ? (length + 1)/2 : length/2 +1;
        int counter = 0;
        while(head != null) {
            counter++;
            if(counter == middle) return head;
            head = head.next;
        }
        return head;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    //TODO solution taken from leetcode discussion. pretty neat
    /*public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;
        }
        return head;
    }*/

    public static void main(String[] args) {
        Problem876 problem876 = new Problem876();
        problem876.solve();
    }

    public void solve() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);
        ListNode result = middleNode(root);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
