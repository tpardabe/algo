package leetcode;

import java.util.*;

public class Problem47 {

    public static void main(String[] args) {
        Problem47 problem47  = new Problem47();
        problem47.solve();
    }

    public void solve() {
        int[] nums = {1, 1, 2, 3, 1};
        List<List<Integer>> result = permuteUnique(nums);
        System.out.println("size: "+result.size());
        for(int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++)
                System.out.print(result.get(i).get(j));
            System.out.println();
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result =  new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        Set<List<Integer>> set  = new HashSet<>();
        List<Integer> original = new LinkedList<>();
        for(int number :nums) original.add(number);
        List<Integer> chosen  =  new LinkedList<>();
        permute(chosen, original, set, result);
        return result;
    }

    public void permute(List<Integer> chosen, List<Integer> leftInteger, Set<List<Integer>> set, List<List<Integer>> result) {
        if(leftInteger.size() == 0) {
            if(!set.contains(chosen)) {
                List<Integer> tmp = new ArrayList<>();
                for(int number: chosen) tmp.add(number);
                result.add(tmp);
                set.add(chosen);
            }
        }
        for(int i =0 ; i < leftInteger.size(); i++) {
            //chose an element
            Integer number =  leftInteger.get(i);
            chosen.add(number);
            leftInteger.remove(i);
            permute(chosen, leftInteger, set, result);
            //unchhose and put back the element
            leftInteger.add(i, number);
            chosen.remove(chosen.size()-1);
        }
    }
}
