package leetcode;

public class Problem237 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    ListNode head;
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Problem237 problem237 = new Problem237();
        problem237.solve();
    }
    public void solve(){
        head = new ListNode(4);
        ListNode node = new ListNode(5);
        head.next = node;
        node.next = new ListNode(1);
        node.next.next = new ListNode(9);
        deleteNode(node);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
