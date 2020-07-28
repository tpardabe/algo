package leetcode;


class Problem1512 {
    public int numIdenticalPairs(int[] nums) {
        int pairs = 0;
        int[] numbers = new int[101];
        for(int i = 0; i < nums.length; i++) {
            pairs += numbers[nums[i]]++;
        }
        return pairs;
    }
}
