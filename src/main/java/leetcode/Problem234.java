package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Problem234 {
    /*public boolean isPalindrome(ListNode head) {
        ListNode headPointer = head;
        List<Integer> list = new ArrayList();
        while(headPointer != null) {
            list.add(headPointer.val);
            headPointer = headPointer.next;
        }
        int mid = list.size()/2;
        int i = 0;
        int j = 0;
        if(list.size() %2 == 0) {
            i = mid-1;
            j = mid;
        } else {
            i = j = mid;
        }
        boolean isPalindrom = true;
        while(i >= 0 && j < list.size()) {
            int x = list.get(i--);
            int y = list.get(j++);
            if(x != y) {
                isPalindrom = false;
                break;
            }
        }
        return isPalindrom;
    }*/

    public boolean isPalindrome(ListNode head) {
        ListNode headPointer = head;
        int size = 0;
        while(headPointer != null) {
            size++;
            headPointer = headPointer.next;
        }
        if(size == 1) return true;
        ListNode left = null;
        ListNode right = null;
        ListNode tail = null;
        int counter = 0;
        int middle = size/2;
        headPointer = head;
        boolean isPalindrom = true;
        while(headPointer != null) {
            if(middle == counter) {
                left = tail;
                if(size %2 == 0) {
                    right = headPointer;
                } else {
                    right = headPointer.next;
                }
                break;
            }
            ListNode next = headPointer.next;
            headPointer.next = tail;
            tail = headPointer;
            counter++;
            headPointer = next;
        }
        while(left != null && right != null) {
            if(left.val != right.val) isPalindrom = false;
            left =left.next;
            right = right.next;
        }
        return isPalindrom;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public static void main(String[] args) {
        Problem234 solution = new Problem234();
        solution.solve();
    }
    public void solve() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(-129);
        root.next.next = new ListNode(1);
        System.out.println(isPalindrome(root));
    }

}
