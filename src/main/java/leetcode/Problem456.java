package leetcode;

import java.util.Stack;

public class Problem456 {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int s3 = Integer.MIN_VALUE;
        for(int i = nums.length-1; i>=0; i--) {
            if(stack.isEmpty() || nums[i] > stack.peek()) {
                while(!stack.isEmpty() && nums[i] > stack.peek()) {
                    int tmp  = stack.pop();
                    if(tmp > s3) s3 = tmp;
                }
                stack.push(nums[i]);
            } else if(nums[i] >= s3) stack.push(nums[i]);
            else return true;
        }
        return false;
    }

    public static void main(String[]args) {
        int[] nums = {8,10,7,9};
        Problem456 problem456 = new Problem456();
        System.out.println(problem456.find132pattern(nums));
    }
}
