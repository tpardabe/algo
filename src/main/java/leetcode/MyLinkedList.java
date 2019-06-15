package leetcode;

class MyLinkedList {

    /**
     * Initialize your data structure here.
     */
    int val;
    ListNode head;

    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (head == null) return -1;
        ListNode tmp = head;
        int size = 0;
        int returnVal = -1;
        while (tmp != null) {
            if (size++ == index) returnVal = tmp.val;
            tmp = tmp.next;
        }
        return returnVal;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode tmp = new ListNode(val);
        if (head != null) tmp.next = head;
        head = tmp;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode tmp = new ListNode(val);
        ListNode loop = head;
        ListNode prev = null;
        while (loop != null) {
            prev = loop;
            loop = loop.next;
        }
        if (prev == null) head = tmp;
        else prev.next = tmp;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (head == null && index > 0) return;
        int size = 0;
        ListNode tmp = new ListNode(val);
        ListNode loop = head;
        ListNode prev = null;
        while (loop != null) {
            if (size++ == index) {
                if (index == 0) {
                    tmp.next = head;
                    head = tmp;
                } else {
                    prev.next = tmp;
                    tmp.next = loop;
                }
            }
            prev = loop;
            loop = loop.next;
        }
        if (size == index) {
            if (head != null) prev.next = tmp;
            else head = tmp;
        } else if (index == -1) {
            tmp.next = head;
            head = tmp;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        int size = 0;
        ListNode tmp = head;
        ListNode prev = null;
        while (tmp != null) {
            if (size++ == index) {
                if (index == 0) head = tmp.next;
                else prev.next = tmp.next;
            }
            prev = tmp;
            tmp = tmp.next;
        }
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
