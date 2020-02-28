package leetcode;

class Problem154 {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi && nums[lo] >= nums[hi]) {
            int mid = lo +(hi - lo)/2;
            if(nums[mid] > nums[lo]) {
                lo = mid +1;
            } else if(nums[lo] == nums[hi] && nums[lo] == nums[mid]) {
                hi--;
                lo++;
            } else if(nums[lo] == nums[hi] && nums[lo] < nums[mid]) {
                lo = mid +1;
            } else if(nums[mid] > nums[hi]) {
                lo = mid +1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}
