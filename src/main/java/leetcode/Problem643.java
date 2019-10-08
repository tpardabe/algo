package leetcode;

class Problem643 {
    public double findMaxAverage(int[] nums, int k) {
        int maxSoFar = 0;
        int maxCur = 0;
        int counter = 0;
        int i = 0;
        for(; i < k; i++) {
            maxCur += nums[i];
        }
        maxSoFar = maxCur;
        for(; i < nums.length; i++) {
            maxCur = (maxCur - nums[i-k]) + nums[i];
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return (maxSoFar +0d)/k;
    }
}
