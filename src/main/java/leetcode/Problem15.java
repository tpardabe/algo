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
        List<List<Integer>> result = new ArrayList();
        Set<String> set = new HashSet();
        Arrays.sort(nums);
        for(int k = 0; k < nums.length; k++)  {
            int l = k+1;
            int r = nums.length -1;
            int current = nums[k];
            while(l < r) {
                 if(current + nums[l] + nums[r] == 0) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(current);
                        builder.append(nums[l]);
                        builder.append(nums[r]);
                        String s = builder.toString();
                        if(!set.contains(s)) {
                            List<Integer> tmp = new ArrayList();
                            tmp.add(current);
                            tmp.add(nums[l]);
                            tmp.add(nums[r]);
                            result.add(tmp);
                            set.add(s);
                        }
                        l++;
                        r--;
                    } else if(current + nums[l] + nums[r] > 0) {
                        r--;
                    } else l++;
            }
        }
        return result;
    }
}
