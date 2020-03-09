package leetcode;
class Problem1351 {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid[0].length; i++) {
            int lo = 0;
            int hi = grid.length - 1;
            while(lo <=hi) {
                int mid = lo +(hi - lo)/2;
                if(grid[mid][i] < 0) {
                    count += (hi -mid +1);
                    hi = mid -1;
                } else {
                    lo = mid +1;
                }
            }
        }
        return count;
    }
}
