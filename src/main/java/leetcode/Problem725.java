class Problem725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        if(root == null) return result;
        else if(k ==1 ) {
            result[0] =root;
            return result;
        }
        int size = 0;
        for(ListNode l = root; l != null; l = l.next) size++;
        int excess = (size >= k) ? size % k : 0;
        int currentIndex = 0;
        ListNode prev = null;
        int counter = 0;
        int div = (k==1 || size /k == 0) ? 1 : size /k;
        int exc = 1;
        int excDiv = (excess > 0) ? div+1 : div;
        while(root != null) {
            counter++;
            if(counter == 1) {
                if(prev != null) prev.next = null;
                result[currentIndex++] = root;
                if(excess == 0 && (counter +1)%(div+1) ==0) counter = 0;
            } else if(excess > 0 && (counter - exc)%div == 0) {
                counter = 0;
                excess--;
            } else if(excess == 0 && counter%div == 0) counter = 0;
            prev = root;
            root = root.next;
        }
        return result;
    }
}
