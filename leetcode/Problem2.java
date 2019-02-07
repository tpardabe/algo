package leetcode;

import java.math.BigInteger;

public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode finalNode = null;
       ListNode curNode = null;
       ListNode left = l1;
       ListNode right = l2;
       boolean addExtra = false;
       int extra = 0;
       while(left != null || right != null) {
           int leftVal = 0;
           int rightVal = 0;
           if(left != null)leftVal = left.val; else leftVal =  0;
           if(right != null) rightVal = right.val; else rightVal = 0;
           int sum = leftVal + rightVal + extra;
           int sumMode = (sum) % 10;
           ListNode temp = new ListNode(sumMode);
           addExtra = sum > 9 ? true : false;
           extra = sum / 10;
           if(finalNode == null) finalNode = temp;
           else curNode.next = temp;
           curNode = temp;
           if(left != null) left = left.next;
           if(right != null) right =right.next;
       }
       if(addExtra)  {
           ListNode temp = new ListNode(extra);
           curNode.next = temp;
       }
        return finalNode;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}


