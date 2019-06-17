package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem23 {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode head = null;
            ListNode prev = null;
            for(ListNode list: lists) {
                ListNode tmp = list;
                if(head == null) head = tmp;
                if(prev != null) prev.next = tmp;
                while(tmp != null) {
                    prev = tmp;
                    tmp = tmp.next;
                }
            }
            return sortList(head);
        }

        private ListNode sortList(ListNode head) {
            if(head == null) return null;
            List list = new ArrayList();
            while(head != null) {
                list.add(head.val);
                head = head.next;
            }
            return heapSort(list);
        }

        private ListNode heapSort(List<Integer> list) {
            ListNode prev = null;
            for(int i = list.size()/2 -1; i >= 0; i--) {
                heapify(list, i);
            }
            for(int i = list.size() -1; i >=0; i--) {
                ListNode current = sink(list);
                if(prev != null) current.next = prev;
                prev = current;
                heapify(list, 0);

            }
            return prev;
        }

        private void heapify(List<Integer> list, int parentIndex) {
            if(parentIndex >= list.size()-1 || parentIndex*2 +1 >= list.size()) return;
            int parent = list.get(parentIndex);
            int left = list.get(parentIndex*2 +1);
            int right = 0;
            int swapIndex = parentIndex*2 +1;
            int greater = left;
            if(parentIndex*2 +2 < list.size()) {
                right = list.get(parentIndex*2 + 2);
                if(left < right) {
                    greater = right;
                    swapIndex = parentIndex*2 + 2;
                }
            }
            if(parent < greater) {
                list.set(parentIndex, greater);
                list.set(swapIndex, parent);
                heapify(list, swapIndex);
            }
        }
        private ListNode sink(List<Integer> list) {
            int greater = list.get(0);
            int removeIndex = 0;
            if(list.size() != 1) {
                removeIndex = list.size() - 1;
                list.set(0, list.get(list.size() - 1));
                list.set(removeIndex, greater);
            }
            ListNode head = new ListNode(greater);
            list.remove(removeIndex);
            return head;
        }

    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
