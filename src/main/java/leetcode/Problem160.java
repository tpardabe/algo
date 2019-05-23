package leetcode;

public class Problem160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int sizeA = 0;
        int sizeB = 0;
        while(a != null || b!= null) {
            if(a != null) {
                sizeA++;
                a = a.next;
            }
            if(b != null) {
                sizeB++;
                b = b.next;
            }
        }
        ListNode intersection = null;
        while (headA!= null && headB !=null) {
            if(headA.val != headB.val) intersection = null;
            else if(intersection == null && headA == headB) intersection = headA;
            if(sizeA > sizeB) {
                sizeA--;
                headA = headA.next;
            } else if(sizeA < sizeB) {
                sizeB--;
                headB = headB.next;
            } else {
                sizeA--;
                sizeB--;
                headA = headA.next;
                headB = headB.next;
            }
        }
        return intersection;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Problem160 solution = new Problem160();
        solution.solve();
    }
    public void solve() {
        ListNode A = new ListNode(4);
        A.next = new ListNode(1);
        A.next.next = new ListNode(8);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);
        ListNode B = new ListNode(5);
        B.next = new ListNode(0);
        B.next.next = new ListNode(1);
        B.next.next.next = new ListNode(8);//5,0,1,8,4,5
        B.next.next.next.next = new ListNode(4);
        B.next.next.next.next.next = new ListNode(5);
        ListNode result = getIntersectionNode(A,       B);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
