package leetcode;

import java.util.*;

public class Problem15 {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Problem15 problem15 =  new Problem15();
        List<List<Integer>> result = problem15.threeSum(nums);
        for(int i =0; i < result.size(); i++) {
            for (Integer element : result.get(i)) {
                System.out.print(element +" ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>  result = new ArrayList<>();
        Map<Integer, Integer> hash =  new HashMap();
        Map<String, String> junkMap = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++) {
            hash.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j  = i+1; j < nums.length; j++){
                if(i == j) continue;
                int sum = nums[i] + nums [j];
                int numToFind  = (sum <= 0 ) ? Math.abs(sum) : Math.negateExact(sum);
                if((sum < 0 || sum == 0) && hash.containsKey(numToFind)){
                    int index = hash.get(numToFind);
                    String s = ""+ nums[i] +  nums[j] + numToFind;
                    if(i == index || j == index || junkMap.containsKey(s)){

                    } else {
                        add(junkMap, result, nums[i], nums[j], numToFind);
                    }
                } else if( sum > 0 && hash.containsKey(numToFind)) {
                    int index = hash.get(numToFind);
                    String s = ""+ nums[i] +  nums[j] + numToFind;
                    if(i ==  index || j == index || junkMap.containsKey(s)){

                    } else {
                        add(junkMap, result, nums[i], nums[j], numToFind);
                    }
                }
            }
        }
        return result;

    }
    private void add(Map<String, String> junkMap, List<List<Integer>>  result, int a, int b, int c) {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(a);
        tmp.add(b);
        tmp.add(c);
        if(!contains(junkMap, tmp)) {
            result.add(tmp);
        }
    }

    public boolean contains(Map<String, String> map,List<Integer> tmp) {
        Collections.sort(tmp);
        String value = tmp.toString();
        if(map.containsKey(value.toString())) return true;
        else {
            String str = value.toString();
            map.put(str, str);
            return false;
        }
    }

}
