package leetcode;

class Problem1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        boolean result = true;
        int diffX = coordinates[1][0] -coordinates[0][0];
        int diffY = coordinates[1][1] -coordinates[0][1];
        for(int i = 2; i< coordinates.length; i++){
            int y  = coordinates[i][1] - coordinates[i-1][1];
            int x = coordinates[i][0] - coordinates[i-1][0];
            if((diffY != 0 && y != 0 && diffX/diffY != x/y) || (diffX != 0 && x != 0 && diffY/diffX != y/x)) return false;
        }
        return true;
    }
