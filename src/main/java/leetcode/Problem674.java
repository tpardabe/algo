package leetcode;


class Problem674 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) return 0;
        int maxSoFar = 1;
        int maxCurrent = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i -1] < nums[i]) maxCurrent +=1;
            else maxCurrent = 1;
            if(maxCurrent > maxSoFar) maxSoFar = maxCurrent;
        }
        return maxSoFar;
    }
}
