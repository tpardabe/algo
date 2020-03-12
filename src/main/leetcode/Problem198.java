package leetcode;


class Problem198 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        else if(nums.length == 1) return nums[0];
        int curMax = nums[1];
        int prevMax = nums[0];
        for(int i = 2; i < nums.length; i++) {
            int cur = prevMax + nums[i];
            int tmp = curMax;
            if(prevMax < cur) curMax = cur;
            if(prevMax < tmp) prevMax = tmp;
        }
        return (prevMax > curMax) ? prevMax : curMax;
    }
    
}
