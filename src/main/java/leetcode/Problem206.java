package leetcode;

public class Problem206 {
    /*public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode[] list = new ListNode[1];
        recurse(head, list);
        return list[0];
    }

    public ListNode recurse(ListNode head,  ListNode[] list) {
        if(head.next == null) {
            list[0] = head;
            return head;//base case
        }
        ListNode current = head;
        head = head.next;
        current.next = null;
        ListNode next = recurse(head, list);
        next.next = current;
        return current;
    }*/

   /* public ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode previous = null;
        while(head != null) {
            if(head.next == null) {
                result = head;
                result.next = previous;
                break;
            }
            ListNode current = head;
            head = head.next;
            current.next = previous;
            previous = current;
        }
        return result;
    }*/

   public ListNode reverseList(ListNode head) {
       ListNode[] list = new ListNode[1];
       recurse(head, list);
       return list[0];
   }
   public ListNode recurse(ListNode head, ListNode[] list) {
       if(head == null || head.next == null) {
           list[0] = head;
           return head;//base case
       }
       ListNode next = recurse(head.next, list);
       next.next = head;
       head.next = null;
       return head;
   }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        Problem206 problem876 = new Problem206();
        problem876.solve();
    }

    public void solve() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        ListNode result = reverseList(root);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
