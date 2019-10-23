package leetcode;

class Problem532 {
    public int findPairs(int[] nums, int k) {
        if(nums.length < 2) return 0;
        int count = 0;
        Arrays.sort(nums);
        int l = 0;
        int r = 0;
        int prev = Integer.MIN_VALUE;
        while(l < nums.length -1) {
            r = l +1;
            if(prev != nums[l]) {
                while(r < nums.length && nums[r] - nums[l] <= k) {
                    if(nums[r] - nums[l] == k) {
                        count++;
                        break;
                    }
                    r++;
                }
            }
            prev = nums[l];
            l++;
        }
        return count;
    }
}
