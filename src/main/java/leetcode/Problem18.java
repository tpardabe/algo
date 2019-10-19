package leetcode;

class Problem18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        Set<String> set = new HashSet();
        for(int i = 0; i < nums.length-3; i++) {
            for(int j = i+1; j < nums.length - 2; j++) {
                int l = j +1;
                int r = nums.length -1;
                while(l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(nums[i]);
                        builder.append(nums[j]);
                        builder.append(nums[l]);
                        builder.append(nums[r]);
                        if(!set.contains(builder.toString())) {
                            List<Integer> list = new ArrayList();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[l]);
                            list.add(nums[r]);
                            result.add(list);
                            set.add(builder.toString());
                        }
                        l++;
                    } else if(sum > target) r--;
                    else l++;
                }
            }
        }
        return result;
    }
}
