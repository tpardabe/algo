package leetcode;

public class Problem19 {

    public static void main(String[] args) {
        Problem19 solution =  new Problem19();
        solution.solve();
    }

    public void solve() {
        ListNode listNode =  new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        int target = -1;
        ListNode result = removeNthFromEnd(listNode, target);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        int size = 0;
        while(tmp != null) {
            tmp = tmp.next;
            size++;
        }
        tmp = head;
        int currentIndex = 0;
        ListNode previous = null;
        while(tmp != null) {
            if((currentIndex + n) == size){
                if(currentIndex == 0) head = tmp.next;
                else previous.next = tmp.next;
            }
            previous = tmp;
            tmp = tmp.next;
            currentIndex++;

        }
        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
