package leetcode;

class Problem136 {
    public int singleNumber(int[] nums) {
        int num = 0;
        for(int i =0 ; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }
}
