package leetcode;

public class Problem38 {

    public static void main(String[] args) {
        Problem38 problem38 =  new Problem38();
        problem38.solve();
    }

    public void solve() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        //solve using sliding windows with i and j
        if(nums == null ||  nums.length == 0) return 0;
        int max = nums[0];
        int currentMax = 0;
        for(int i = 1; i < nums.length; i++) {
            if( nums[i] > currentMax) {
                currentMax =nums[i];
            } else if(nums[i]+ currentMax >= currentMax) {
                currentMax += nums[i];
            } else {
                currentMax = nums[i];
            }
            max = Math.max(max, currentMax);
        }
        return max;
    }
}
