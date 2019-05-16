package leetcode;

public class Problem63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] matrix = new int[m][n];
        boolean[][] truthMatrix = new boolean[m][n];
        return recurse(0, 0, m, n, matrix, obstacleGrid, truthMatrix);
    }

    public int recurse (int rowIndex, int colIndex, int m, int n, int[][] matrix, int[][] obstacleGrid, boolean[][] truthMatrix) {
        if(rowIndex == m || colIndex == n) return 0;
        else if(obstacleGrid[rowIndex][colIndex] == 1) {
            matrix[rowIndex][colIndex] = 0;
            truthMatrix[rowIndex][colIndex] = true;
            return 0;
        }
        else if(rowIndex == m-1 && colIndex == n-1) {
            matrix[rowIndex][colIndex] = 1;
            truthMatrix[rowIndex][colIndex] = true;
            return 1;
        }
        else if(truthMatrix[rowIndex][colIndex]) return matrix[rowIndex][colIndex];
        int val = recurse(rowIndex+1, colIndex, m, n, matrix, obstacleGrid, truthMatrix) + recurse(rowIndex, colIndex+1, m, n, matrix, obstacleGrid, truthMatrix);
        matrix[rowIndex][colIndex] = val;
        truthMatrix[rowIndex][colIndex] = true;
        return val;
    }

    public static void main(String [] args) {
        int m = 20;
        int n = 15;
        Problem63 problem63 = new Problem63();
        int[][] obstacleGrid = {
                {1}
        };
        int val = problem63.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(val);
    }
}
