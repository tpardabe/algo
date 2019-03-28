package leetcode;
public class Problem11 {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length-1;
        while(i < j) {
            int tmpMax = 0;
            if(height[i] > height[j]){
                tmpMax = height[j] * (j-i);
                j--;
            } else {
                tmpMax = height[i] * (j-i);
                i++;
            }
            max = Math.max(max, tmpMax);
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
