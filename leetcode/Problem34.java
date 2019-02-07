package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem34 {

    public static void main(String[] args) {
        Problem34 solution = new Problem34();
        solution.solve();
    }
    public void solve () {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 11;
        searchRange(nums, target);
    }


    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        binarySearch(nums, target, 0, nums.length - 1, result);
        return result;
    }

    public void binarySearch(int[] nums, int target, int left, int right,  int[] result) {
        if(left > right) return;
        else if(right < left) return;
        int mid = left + (right -left)/2;
        if(nums[mid] == target) {
            if(result[0] == -1 || result[0] > mid) result[0] = mid;
            if(result[1] < mid) result[1] = mid;
            binarySearch(nums, target, left, mid - 1 , result);
            binarySearch(nums, target, mid +1, right, result);
        }
        else if(nums[mid] > target) binarySearch(nums, target, left, mid - 1, result);
        else binarySearch(nums, target, mid +1, right, result);
    }
}
