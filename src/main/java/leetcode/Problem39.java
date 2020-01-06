package leetcode;

class Problem39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> set = new HashSet();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, new LinkedList(), set);
        return new ArrayList(set);
    }
    void dfs(int[] candidates, int target, int index, int current, LinkedList<Integer> list, Set<List<Integer>> set) {
        if(current == target) {
            set.add(new ArrayList(list));
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if(candidates[i] + current > target) return;
            current += candidates[i];
            list.add(candidates[i]);
            dfs(candidates, target, i, current, list, set);
            current -= candidates[i];
            list.removeLast();
        }
    }
}
