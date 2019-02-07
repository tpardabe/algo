package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem46 {


    public static void main(String[] args) {
        Problem46 solution =  new Problem46();
        solution.solve();
    }

    public void solve() {
        //int[] nums = {5,4,6,2};
        int[] nums = {0,- 1, 1};
        int increment = 0;
        List<List<Integer>> list = permute(nums);
        System.out.println("size: "+list.size());
        for(int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++)
                System.out.print(list.get(i).get(j));
            System.out.println();
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list =  new ArrayList<>();
        if(nums == null || nums.length == 0) return list;
        List<Integer> chosen = new LinkedList<>();
        List<Integer> numbers = new LinkedList<>();
        for(int number : nums)numbers.add(number);
        permutate(chosen, numbers, list);
        return list;
    }

    private void permutate(List<Integer> chosen, List<Integer> nums, List<List<Integer>> list) {
        if(nums == null || nums.size() == 0) {
            List<Integer> result =  new ArrayList<>();
            for(int i = 0; i < chosen.size(); i++) result.add(chosen.get(i));
            list.add(result);
            return;
        }
        for(int i  = 0; i < nums.size(); i++) {
            //chose
            int number  = nums.get(i);
            chosen.add(number);
            nums.remove(i);
            //refill the rest
            permutate(chosen, nums, list);
            //unfil the rest
            nums.add(i, number);
            chosen.remove(chosen.size()-1);
        }
    }
}
