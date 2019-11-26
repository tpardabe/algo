package leetcode;

class Problem950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < deck.length; i++) queue.add(i);
        int[] result = new int[deck.length];
        int curIndex = 0;
        while(!queue.isEmpty()) {
            result[queue.poll()] = deck[curIndex++];
            if(!queue.isEmpty()) queue.add(queue.poll());
        }
        return result;
    }
}
