package leetcode;

class Problem52 {
    int count = 0;
    public int totalNQueens(int n) {
        count = 0;
        dfs(new int[n], new int[n], new int[2*n-1], new int[2*n-1], 0, n);
        return count;
    }
    
    void dfs(int[] col, int[] rows, int[] diagX, int[] diagY, int row, int n) {
        if(row == rows.length) {
            if(n == 0) count++;
            return;
        }
        for(int i = 0; i < col.length; i++) {
            int x = col.length - 1;
            if(col[i] > 0) continue;
            else if(rows[row] > 0) continue;
            else if(diagX[i + row] > 0) continue;
            else if(diagY[x - i + row] > 0) continue;
            col[i] += 1;
            rows[row] += 1;
            diagX[i + row] += 1;
            diagY[x - i + row] += 1;
            dfs(col, rows, diagX, diagY, row + 1, n - 1);
            col[i] -= 1;
            rows[row] -= 1;
            diagX[i + row] -= 1;
            diagY[x - i + row] -= 1;
        }
    }
}
