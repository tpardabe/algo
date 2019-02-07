package leetcode;

public class Problem55 {
    public  static void main(String[] args) {
        int[] number = {0, 1};
        Problem55 problem55 =  new Problem55();
        System.out.println(problem55.canJump(number));
    }

    public boolean canJump(int[] nums) {
        if(nums == null) return false;
        boolean result = true;
        int i = 1;
        while( i < nums.length) {
            if(i == nums.length-1 || (nums[i] == 0 && nums.length == 1)) {
                result = true;
                break;
            }
            else if(nums[i] == 0) {
                result = false;
                break;
            }
            i += nums[i];
        }
        return result;
    }
}
