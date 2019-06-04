package leetcode;

public class Problem92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode sentinel = new ListNode(Integer.MAX_VALUE);
        sentinel.next = head;
        reverse(sentinel.next, sentinel, new ListNode(Integer.MAX_VALUE), sentinel, m, n, 1);
        return sentinel.next;
    }

    private ListNode reverse(ListNode head, ListNode prev, ListNode next, ListNode current, int m, int n, int count) {
        if(count == n) {
            next.val = head.val;
            next.next = head.next;
            current.next = head;
            return head;
        }
        if(count == m) current = prev;
        ListNode tail = reverse(head.next, head, next, current,  m, n, count + 1);
        if(count >= m) {
            tail.next = head;

        }
        if(count == m){
            head.next = next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Problem92 sol = new Problem92();
        sol.solve();
    }

    private void solve() {
        ListNode root = new ListNode(3);
        root.next = new ListNode(5);
        /*root.next.next = new ListNode(4);
        root.next.next.next = new ListNode(5);
        root.next.next.next.next = new ListNode(6);*/
        int m = 2;
        int n = 2;
        ListNode result = reverseBetween(root, m, n);
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
