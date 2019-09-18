package leetcode;
class Problem1051 {
    public int heightChecker(int[] heights) {
        int[] array = Arrays.copyOf(heights, heights.length);
        int count = 0;
        Arrays.sort(array);
        for(int i = 0; i < array.length; i++) {
            if(heights[i] != array[i]) {
                count +=1;
            }
        }
        return count;
    }
}
