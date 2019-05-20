package leetcode;


public class Problem86 {
    public ListNode partition(ListNode head, int x) {
        ListNode lessX = null;
        ListNode result = head;
        ListNode previous = null;
        ListNode next = null;
        while(head != null) {
            if(head.val < x) {
                if(lessX == null) {
                    lessX = head;
                    if(next != null) {
                        previous.next = lessX.next;
                        lessX.next = next;
                    }
                    result = head;
                    head = head.next;
                } else if(previous.val < x) {
                    lessX = head;
                    head = head.next;
                } else {
                    next = lessX.next;
                    previous.next = head.next;
                    lessX.next = head;
                    lessX = head;
                    head.next = next;
                    head = head.next;
                }
                previous = head;
            } else {
                previous = head;
                if(next == null) next = head;
                head = head.next;
            }
        }
        return result;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  public static void main(String[] args ) {
      Problem86 problem86 = new  Problem86();
      problem86.solve();
  }
  public void solve() {
      ListNode s = new ListNode(1);
      s.next = new ListNode(3);
      s.next.next = new ListNode(1);
      s.next.next.next = new ListNode(5);
      s.next.next.next.next = new ListNode(2);
      s.next.next.next.next.next = new ListNode(1);
      int x = 3;
      ListNode  result  =partition(s, x);
      while (result != null) {
          System.out.println(result.val);
          result = result.next;
      }
  }
}
