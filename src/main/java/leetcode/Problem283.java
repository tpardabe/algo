package leetcode;


class Problem283 {
    public void moveZeroes(int[] nums) {
        int count = 0;
        int start = 0;
        int end = nums.length -1;
        for(int i = 0; i < nums.length; ) {
            if(nums[i] == 0) {
                count++;
                if(count == 1) start = i;
            } else if(count > 0) {
                shift(nums, start, end, count);
                end -= count;
                count = 0;
                i = start;
            }
            i++;
        }
    }
    
    void shift(int[] nums, int start, int end, int count) {
        if(start + count >= nums.length) return;
        for(; start + count < nums.length && start <= end - count; start++) {
            nums[start] = nums[start + count];
        }
        while(count-- > 0) {
            nums[start++] = 0;
        }
    }
}
