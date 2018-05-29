package leetcode;

public class Problem35 {

    public static void main(String[]args) {
        Problem35 solution =  new Problem35();
        solution.solve();
    }

    public void solve() {
        int[] nums =  {1,3,5,6};
        int target = 0;
        System.out.println(searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length -1);
    }

    public int binarySearch(int[] nums, int target, int left, int right) {
        if(left > right) return left;
        else if(right < left) return right >0 ? right : 0;
        int mid = left + (right -left)/2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] > target) return binarySearch(nums, target, left, mid - 1 );
        else return binarySearch(nums, target, mid +1, right);
    }
}
