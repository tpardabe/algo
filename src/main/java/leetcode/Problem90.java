package leetcode;

class Problem90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet();
        dfs(result, new ArrayList(), 0, nums);
        return new ArrayList(result);
    }
    
    void dfs(Set<List<Integer>> result, List<Integer> list, int start, int[] nums) {
        result.add(new ArrayList(list));
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i -1 ] == nums[i]) continue;
            list.add(nums[i]);
            dfs(result, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }
}
