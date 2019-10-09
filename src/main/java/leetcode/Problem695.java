package leetcode;

class Problem695 {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(!visited[i][j]) max = Math.max(dfs(grid, visited, i, j), max);
            }
        }
        return max;
    }
    
    int dfs(int[][] grid, boolean[][] visited, int x, int y) {
        if(x <0 || y < 0 || x >= grid.length || y >=grid[0].length) return 0;
        else if(visited[x][y]) return 0;
        else if(grid[x][y] == 0) return 0;
        visited[x][y] = true;
        return dfs(grid, visited, x-1, y) + 
            dfs(grid, visited, x, y+1) +
            dfs(grid, visited, x, y-1) + 
            dfs(grid, visited, x+1, y) + 1;
    }
}
