package leetcode;

class Problem1267 {
    public int countServers(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];
        int connected = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    rows[i] += 1;
                    cols[j] += 1;
                }
            }
        }
        for(int i = 0; i < rows.length; i++) {
            for(int j = 0; j < cols.length; j++) {
                if(grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1)) connected++;
            }
        }
        return connected;
    }
}
