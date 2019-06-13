package leetcode;
import java.util.HashSet;
import java.util.Set;

public class Problem142 {
    boolean [] found = new boolean[1];
    ListNode result = null;
    public ListNode detectCycle1(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        Set<ListNode> set = new HashSet();
        boolean hasCycle = false;
        ListNode union = null;
        boolean breakingCycle = false;
        while(slow != null && !breakingCycle && fast != null && fast.next != null) {
            if(fast == slow) {
                hasCycle = true;
                if(union == slow) breakingCycle = true;
                union = slow;
            }
            if(hasCycle) set.add(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(hasCycle) return recurse(head, set);
        else return null;
    }
    
    private ListNode recurse(ListNode head, Set set) {
        if(set.contains(head)) return head;
        return recurse(head.next, set);
    }


    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode sentinel = new ListNode(Integer.MAX_VALUE);
        sentinel.next = head;
        recursion(sentinel, sentinel.next, sentinel, sentinel);
        return result;
    }

    private void recursion(ListNode slow, ListNode fast, ListNode prev, ListNode head) {
        ListNode next = null;
        if(slow == null ) return;
        else if(!found[0] && (fast == null || fast.next == null)) return;
        else if(slow == fast && !found[0]) {
            found[0] = true;//found the cycle
            next = slow.next;
        }
        else if(found[0]) {
            if(prev != slow) next = slow.next;
            prev.next = null;
        }
        else if(fast != null && fast.next != null) fast = fast.next.next;
        if(!found[0]) next = slow.next;
        recursion(next, fast, slow, head);
        if(slow.next == null && found[0]) {
            while(head != null) {
                if(head.next == null) result = head;
                head = head.next;
            }
        }
        prev.next = slow;
    }

    public static void main(String[] args) {
        Problem142 sol = new Problem142();
        sol.solve();
    }

    private void solve() {
        ListNode root = new ListNode(1);
        /*ListNode next = new ListNode(2);
        root.next = next;
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next = next;*/
        ListNode result = detectCycle(root);
        if(result != null) System.out.println(result.val);
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
