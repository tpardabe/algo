package leetcode;

class Problem1219 {
    public int getMaximumGold(int[][] grid) {
        int x = grid[0].length;
        int y = grid.length;
        boolean[][] visited = new boolean[y][x];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                max = Math.max(max, collect(j, i, visited, grid));
            }
        }
        return max;
    }
    
    int collect(int x, int y, boolean[][] visited, int[][] grid) {
        if(x < 0 || x >= grid[0].length) return 0;
        else if(y < 0 || y >= grid.length) return 0;
        else if(grid[y][x] == 0) return 0;
        else if(visited[y][x]) return 0;
        int maximum = Integer.MIN_VALUE;
        visited[y][x] = true;
        maximum = Math.max(maximum, collect(x - 1, y, visited, grid));
        maximum = Math.max(maximum, collect(x + 1, y, visited, grid));
        maximum = Math.max(maximum, collect(x, y - 1, visited, grid));
        maximum = Math.max(maximum, collect(x, y + 1, visited, grid));
        visited[y][x] = false;
        return maximum + grid[y][x];
    }
}
