package leetcode;


class Problem485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int index = -1;
        for(int i = 0 ; i < nums.length; i++) {
            if(nums[i] == 1 && index == -1) {
                index = i;
            } else if(nums[i] == 0 && index > -1) {
                count = Math.max(count, i - index);
                index = -1;
            }
        }
        if(count > -1) {
            count = Math.max(count, nums.length - index);
        }
        return count;
    }
}
