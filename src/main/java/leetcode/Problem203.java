package leetcode;

public class Problem203 {
    public ListNode removeElements(ListNode head, int val) {
        return recurse(null, val, head);
    }

    public ListNode recurse(ListNode result, int val, ListNode head){
        if(head == null) return result;
        if(head.next != null&& head.next.val == val) {
            head.next = head.next.next;
        } else {
            if(head.val != val && result == null) result = head;
            head = head.next;
        }
        return recurse(result, val, head);
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Problem203 problem203 = new Problem203();
        problem203.solve();
    }
    public void solve(){
        ListNode head = new ListNode(4);
        ListNode node = new ListNode(5);
        head.next = node;
        node.next = new ListNode(4);
        node.next.next = new ListNode(6);
        ListNode result = removeElements(head, 4);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
