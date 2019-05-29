package leetcode;

public class Problem430 {
    public Node flatten(Node head) {
        Node sentinental = new Node(Integer.MAX_VALUE, null, head, null);
        recurse(sentinental.next, sentinental.next);
        return sentinental.next;
    }

    public Node recurse(Node current, Node tail) {
        if(current == null) {
            return tail;
        }
        if(current.child != null) {
            Node child = current.child;
            Node tailNode = recurse(current.child, current.child);
            Node tmp = current.next;
            current.next = child;
            child.prev = current;
            tailNode.next = tmp;
            if(tmp != null) tmp.prev = tailNode;
            current.child = null;
        }
        return recurse(current.next, current);
    }
    public static void main(String[] args) {
        Problem430 solution = new Problem430();
        solution.solve();
    }

    private void solve() {
        Node root = new Node(1, null, null, null);
        Node sec = new Node(2, root, null, null);
        root.next = sec;

        Node third = new Node(3, sec, null, null);
        sec.next = third;

        Node fourth = new Node(4, third, null, null);
        Node fifth = new Node(5, fourth, null, null);
        fourth.next = fifth;
        Node sixth = new Node(6, fifth, null, null);
        fifth.next = sixth;

        Node child1 = new Node(7, null, null, null);
        third.child = child1;
        third.next = fourth;

        Node child1Sec = new Node(8, child1, null, null);
        child1.next = child1Sec;


        Node childThird = new Node(9, child1Sec, null, null);
        child1Sec.next = childThird;

        Node childFourth = new Node(10, childThird, null, null);
        childThird.next = childFourth;
        Node secChildFirst = new Node(11, null, null, null);
        Node secChildSec = new Node(12, secChildFirst, null, null);
        secChildFirst.next = secChildSec;
        child1Sec.child = secChildFirst;
        Node result = flatten(root);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
        //1->2->3->7->8->11->12->9->10->4->5->6->
        //1-2-3-7-8-11-12-9-10-4-5-6-NULL
    }




    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
}
