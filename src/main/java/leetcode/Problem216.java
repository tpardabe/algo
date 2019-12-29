package leetcode;


class Problem216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        boolean[] visited = new boolean[10];
        List<List<Integer>> result = new ArrayList();
        dfs(result, k, n, 0, new ArrayList(), visited, 1);
        return result;
    }
    
    void dfs(List<List<Integer>> result, int k, int n, int sum, List<Integer> list, boolean[] visited, int start) {
        if(k == 0 ) {
            if(sum == n) result.add(new ArrayList(list));
            return;
        }
        for(int i = start; i <= 9; i++) {
            if((sum + i > n) || (visited[i])) continue;
            list.add(i);
             visited[i] = true;
            dfs(result, k -1, n, sum + i, list, visited, i);
            list.remove(list.size() -1);
            visited[i] = false;
        }
    }
}
