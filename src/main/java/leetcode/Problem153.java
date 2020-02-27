package leetcode;

class Problem153 {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while(nums[lo] >= nums[hi]) {
            int mid = lo + (hi -lo)/2;
            if(nums[lo] > nums[mid]) {
                hi = mid;
            } else {
                lo = mid +1;
            }
            if(lo >= hi) break;
        }
        return (lo > hi) ? nums[hi] :nums[lo];
    }
}
