package leetcode;

class Problem268 {
    public int missingNumber(int[] nums) {
        int i = 0;
        int j = 0;
        int prev = Integer.MIN_VALUE;
        while(i < nums.length) {
            int num = (prev >=0) ? prev : nums[i];
            if(num >=0 && num < nums.length) {
                if(prev < 0)i++;
                prev = nums[num];
                nums[num] = -1;
            }
            if(num == -1|| num >= nums.length) {
                i = ++j;
                prev = Integer.MIN_VALUE;
            }
        }
        for(i = 0; i < nums.length; i++) {
            if(nums[i] >=0) return i;
        }
        return nums.length;
    }
