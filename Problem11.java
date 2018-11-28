public class Problem11 {
    public int maxArea(int[] height) {
        int max = 0;
        int least = height[0];
        int leastIndex = 0;
        for(int i = 1 ; i < height.length; i++) {
            int tmpMax = (height[i] > height[i-1]) ? height[i-1] : height[i];
            int tmp = (height[i] > least) ? least *(i- leastIndex) : height[i] *(i- leastIndex);
            if(tmpMax > tmp) {
                leastIndex = i-1;
                least = height[i-1];
            }
            max = Math.max(tmp, tmpMax);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] height = {1,4,6,2,5,8,8,3,7};
        Problem11 problem11 =  new Problem11();
        int max = problem11.maxArea(height);
        System.out.println(max);
    }
}
