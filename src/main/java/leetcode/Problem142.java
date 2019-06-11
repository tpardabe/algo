public class Problem142 {
    public ListNode detectCycle(ListNode head) {
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
    
     class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
