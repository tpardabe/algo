package leetcode;

public class Problem61 {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int size = 0;
        ListNode next = head;
        while(next != null) {
            next = next.next;
            size++;
        }
        next = head;
        int index = 0;
        k = k%size;
        if(k == 0) return head;
        ListNode start = next;
        while(next != null) {
            index++;
            if(index +k == size) {
                start = next.next;
                next.next = null;
                next = start;
            } else {
                if(index == size) {
                    next.next = head;
                } else next = next.next;
            }

        }
        return start;
    }


    public static void main(String[] args) {
        Problem61 problem61 = new Problem61();
        problem61.solve();
    }
    public void solve(){
        ListNode head = new ListNode(1);
        ListNode x1 = new ListNode(2);
        head.next = x1;
        ListNode x2 = new ListNode(3);
        x1.next = x2;
        ListNode x3 = new ListNode(4);
        x2.next = x3;
        ListNode x4 = new ListNode(5);
        x3.next = x4;
        ListNode result = rotateRight(head, 2);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
