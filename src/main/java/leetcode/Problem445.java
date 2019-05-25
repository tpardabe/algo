package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        for(ListNode tmp = l1; tmp != null; tmp = tmp.next) first.append(tmp.val);
        for(ListNode tmp = l2; tmp != null; tmp = tmp.next) second.append(tmp.val);
        String s1 = first.toString();
        String s2 = second.toString();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int num = (s1.charAt(i--) - '0') + (s2.charAt(j--) - '0');
        int excess = num / 10;
        List<Integer> list = new ArrayList();
        list.add(num % 10);
        while(i >= 0 || j >= 0) {
            if(i >= 0 && j >= 0) {
                num = (s1.charAt(i--) - '0') + (s2.charAt(j--) -'0') + excess;
                excess = num / 10;
                list.add(num % 10);
            } else if(i >= 0) {
                num = s1.charAt(i--) - '0' + excess;
                excess = num / 10;
                list.add(num % 10);
            } else {
                num = s2.charAt(j--) - '0' + excess;
                excess = num / 10;
                list.add(num % 10);
            }
        }
        if(excess > 0) list.add(excess);
        ListNode result = new ListNode(list.get(list.size() - 1));
        ListNode prev = result;
        for(i = list.size() - 2; i >=0; i--) {
            prev.next = new ListNode(list.get(i));
            prev = prev.next;
        }
        return result;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public static void main(String [] args) {
        Problem445 sol = new Problem445();
        sol.solve();
    }

    public void solve() {
        ListNode root = new ListNode(7);
        root.next = new ListNode(2);
        root.next.next = new ListNode(4);
        root.next.next.next = new ListNode(3);
        ListNode next = new ListNode(5);
        next.next = new ListNode(6);
        next.next.next = new ListNode(4);


        ListNode result = addTwoNumbers(root, next);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
