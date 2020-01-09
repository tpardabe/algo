package leetcode;

class Problem357 {
    public int countNumbersWithUniqueDigits(int n) {
        if(n ==0) return 1;
        return dfs(new boolean[10], n, n);
    }
    
    int dfs(boolean[] visited, int n, int remain) {
        if(remain == 0) return 0;
        int res = 0;
        for(int i = 0; i < 10; i++) {
            if(visited[i]) continue;
            res++;
            visited[i] = true;
            if(i > 0 || n != remain) res +=dfs(visited, n, remain - 1);
            visited[i] = false;
        }
        return res;
    }
}
