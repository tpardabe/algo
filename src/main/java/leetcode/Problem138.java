package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem138 {
    public Node copyRandomList(Node head) {
        Node result = null;
        Node next = null;
        Node tmpHead = head;
        Map<Node, Node> map = new HashMap();
        while(tmpHead != null) {
            Node tmp = new Node();
            tmp.val = tmpHead.val;
            map.put(tmpHead, tmp);
            if(next == null) {
                result = tmp;
                next = tmp;
            } else {
                next.next = tmp;
                next = tmp;
            }
            tmpHead = tmpHead.next;
        }
        Node tmp = result;
        while (tmp != null && head != null) {
            if(map.containsKey(head.random)) tmp.random = map.get(head.random);
            tmp = tmp.next;
            head = head.next;
        }
        return result;
    }


    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
