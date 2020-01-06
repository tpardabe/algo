package leetcode;

class Problem40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> result = new HashSet();
        dfs(result, candidates, target, 0, new LinkedList());
        return new ArrayList(result);
    }
    void dfs(Set<List<Integer>> result, int[] candidates, int target, int index, LinkedList<Integer> list) {
        if(target == 0) {
            result.add(new ArrayList(list));
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if(target - candidates[i] < 0) return;
            if(i != index && candidates[i-1] == candidates[i]) continue;//already used
            list.add(candidates[i]);
            dfs(result, candidates, target - candidates[i], i + 1, list);
            list.removeLast();
        }
    }
}
