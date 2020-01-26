package leetcode;

class Problem60 {
    
    int count;
    String result;
    public String getPermutation(int n, int k) {
        count = k;
        dfs(n, new boolean[n + 1], new StringBuilder());
        return result;
    }
    
    void dfs(int n, boolean[] visited, StringBuilder builder) {
        if(builder.length() == n) count--;
        if(count == 0) {
            result = builder.toString();
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(result != null) return;
            if(visited[i]) continue;
            visited[i] = true;
            builder.append(i);
            dfs(n, visited, builder);
            visited[i] = false;
            builder.setLength(builder.length() - 1);
        }
    }
}
