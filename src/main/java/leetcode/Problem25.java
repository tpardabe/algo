package leetcode;

import java.util.ArrayList;
import java.util.List;

class Problem25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        List<Integer> list =  new ArrayList();
        ListNode result = null;
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        int i = 0;
        boolean reverse = false;
        if(list.size() >=k) {
            i = k-1;
            reverse = true;
        } else i = 0;
        int numberOfElements = 0;
        ListNode next = null;
        int curCount = 0;
        while (numberOfElements < list.size()) {
            ListNode tmp = new ListNode(list.get(i));
            numberOfElements++;
            curCount++;
            if(numberOfElements == 1) {
                result = tmp;
                next = result;
            } else {
                next.next = tmp;
                next = tmp;
            }
            if(reverse) i--;
            else i++;
            if(curCount == k ) {
               if(list.size() >= numberOfElements + k) {
                    i = numberOfElements + k-1;
                    reverse = true;
                } else {
                    i = numberOfElements;
                    reverse = false;
                }
               curCount = 0;
            }
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
