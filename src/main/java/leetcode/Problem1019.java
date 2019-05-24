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
    public static void main(String[] args) {
        Problem1019 solution = new Problem1019();
        solution.solve();
    }
    public void solve() {
        ListNode root = new ListNode(2);
        root.next = new ListNode(1);
        root.next.next = new ListNode(5);
        int[] result = nextLargerNodes(root);
        for(int s: result) System.out.println(s);
    }
}
