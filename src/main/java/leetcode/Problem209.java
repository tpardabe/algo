package leetcode;

class Problem209 {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int r = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        boolean found = false;
        while(r < nums.length) {
            while(l < r && sum - nums[l] >= s -nums[r]) {
                sum -= nums[l++];
            }
            sum += nums[r];
            if(sum >= s) {
                min = Math.min(min, r - l +1);
                found = true;
            }
            r++;
        }
        return found ? min : 0;
    }
