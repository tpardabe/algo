package leetcode;

class Problem526 {
    int count;
    public int countArrangement(int N) {
        count = 0;
        dfs(new boolean[N + 1], 1, N);
        return count;
    }
    
    void dfs(boolean[] visited, int index, int N) {
        if(index > N) {
            count++;
            return;
        }
        for(int i =1; i <= N; i++) {
            if(!visited[i] && (i % index == 0 || index % i == 0)) {
                visited[i] = true;
                dfs(visited, index + 1, N);
                visited[i] = false;
            }
        }
    }
}
