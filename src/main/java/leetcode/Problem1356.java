package leetcode;
class Problem1356 {
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, List<Integer>> map = new HashMap();
        for(int num: arr) {
            int count = Integer.bitCount(num);
            if(!map.containsKey(count)) {
                List<Integer> list = new ArrayList();
                map.put(count, list);
            }
            map.get(count).add(num);
            map.put(count, map.get(count));
        }
        List<Integer> list = new ArrayList();
        for(int i = 0; i < 33; i++) {
            if(map.containsKey(i)) {
                list.addAll(map.get(i));
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
  
}
