package leetcode;


class Problem16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sumClosest = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        int newDiff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i ++) {
            int l = i+1;
            int r = nums.length - 1;
            while(l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if((target > 0 && sum > 0) || (target < 0 && sum < 0)) newDiff = Math.abs(target - sum);
                else newDiff = Math.abs(target) + Math.abs(sum);
                if(newDiff < diff) {
                    diff = newDiff;
                    sumClosest = sum;
                }
                if(sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return sumClosest;
    }
}
