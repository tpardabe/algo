package leetcode;

import java.util.*;

public class Problem442 {

    public static void main(String[] args ){
        Problem442 solution = new Problem442();
        solution.solve();
    }

    public void solve(){
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = findDuplicates(nums);
        for(int item : list)System.out.println(item);
    }

    /*public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> map =  new HashMap<>();
        List<Integer> result =  new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) result.add(nums[i]);
            map.put(nums[i], nums[i]);
        }
        Collections.sort(result);
        return result;
    }*/
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result =  new ArrayList<>();
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0 ) {
                index = nums[i] - 1;
            } else {

            }
        }
        Collections.sort(result);
        return result;
    }
}
