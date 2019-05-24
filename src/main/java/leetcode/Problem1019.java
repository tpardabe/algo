package leetcode;

import java.util.Stack;

public class Problem1019 {
    public int[] nextLargerNodes(ListNode head) {
        Stack<ListNode> stack = new Stack();
        int size = recurse(head, stack);
        int[] result = new int[size];
        ListNode current;
        int currentIndex = 0;
        while (!stack.empty() && ( current = stack.pop()) != null){
            boolean found = false;
            ListNode next = current.next;
            while(!found && next != null) {
                if(current.val < next.val) {
                    found = true;
                    result[currentIndex] = next.val;
                }
                next = next.next;
            }
            currentIndex++;
        }
        return result;
    }

    private int recurse(ListNode head, Stack stack) {
        if(head == null) return 0;
        int size = recurse(head.next, stack);
        stack.push(head);
        return size + 1;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
