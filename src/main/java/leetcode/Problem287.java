package leetcode;


class Problem287 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(prev == nums[i]) return prev;
            prev = nums[i];
        }
        return 0;
    }
}
