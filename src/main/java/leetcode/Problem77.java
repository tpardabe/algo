package leetcode;

class Problem77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList();
        dfs(list, new LinkedList(), 1, n, k);
        return list;
    }
    
    void dfs(List<List<Integer>> result, LinkedList<Integer> list, int start, int n, int k) {
        if(list.size() == k) {
            result.add(new ArrayList(list));
            return;
        }
        for(int i = start; i <= n; i++) {
            list.add(i);
            dfs(result, list, i + 1, n, k);
            list.removeLast();
        }
    }
}
