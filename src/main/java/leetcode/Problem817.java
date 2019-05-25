package leetcode;

import java.util.HashSet;
import java.util.Set;

class Problem817 {
    public int numComponents(ListNode head, int[] G) {
        Set map = new HashSet();
        for(int val: G) map.add(val);
        int components = 0;
        boolean newNode= true;
        while (head != null) {
            if(map.contains(head.val) && newNode) {
                components++;
                 newNode = false;                                  }
            else if(!map.contains(head.val)) newNode = true;
            head =head.next;
        }
        return components;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
