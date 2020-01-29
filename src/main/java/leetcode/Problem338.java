package leetcode;

class Problem338 {
    Map<Integer, Integer> map = new HashMap();
    public int[] countBits(int num) {
        int[] result = new int[num +1];
        map.put(0, 0);
        for(int i = num; i > 0 ; i--) {
            result[i] = bits(i);
        }
        return result;
    }
    
    int bits(int num) {
        if(map.containsKey(num)) return map.get(num);
        int cur = num;
        int count = cur % 2;
        count += bits(num >>1);
        map.put(num, count);
        return count;
    }
}
