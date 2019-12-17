package leetcode;

class Problem51 {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] visited = new boolean[n][n];
        List<List<String>> result = new ArrayList();
        int[] col = new int[n];
        int[] row = new int[n];
        int[] diagX = new int[(2*n) - 1];
        int[] diagY = new int[(2*n) - 1];
        dfs(n, visited, result, 0, col, row, diagX, diagY);
        return result;
    }
    
    void dfs(int n, boolean[][] visited, List<List<String>> list, int r, int[] col, int[] row, int[] diagX, int[] diagY) {
        if(r == row.length) {
            if(n == 0) {
                List<String> t = new ArrayList();
                for(int i = 0; i < visited.length; i++) {
                    StringBuilder builder = new StringBuilder();
                    for(int j = 0; j < visited[i].length; j++){
                        if(visited[i][j]) builder.append("Q");
                        else builder.append(".");
                    }
                    t.add(builder.toString());
                }
                list.add(t);
            }
            return;
        }
        for(int i = 0; i < col.length; i++) {
            int x = col.length - 1;
            if(visited[r][i] || col[i] > 0 || row[r] > 0 ||
               diagX[i + r] > 0 || diagY[x - i + r] > 0) continue;
            visited[r][i] = true;
            col[i] ++;
            row[r] ++;
            diagX[i + r] ++;
            diagY[x - i + r]++;
            dfs(n - 1, visited, list, r + 1, col, row, diagX, diagY);
            visited[r][i] = false;
            col[i] --;
            row[r] --;
            diagX[i + r] --;
            diagY[x - i + r]--;
        }
        
    }
    
}
