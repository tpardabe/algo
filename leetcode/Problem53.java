package leetcode;

public class Problem53 {

    public static void main(String[] args ){
        Problem53 solution = new Problem53();
        solution.solve();
    }

    public void solve(){
        int[] arrray = {2,3,-2,4};
        System.out.println(maxSubArray(arrray));
    }
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0 )return 0;
        int max = nums[0];
        int tmpMax = max;
        for(int i = 1;i < nums.length; i++) {
            int number  = nums[i];
            if(number >= (number + tmpMax))tmpMax = number;
            else tmpMax+=number;
            max = Math.max(max, tmpMax);
        }
        return max;
    }
}
