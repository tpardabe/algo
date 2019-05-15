package leetcode;

public class Problem62 {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[n][m];
        return recurse(0, 0, m, n, matrix);
    }

    public int recurse (int rowIndex, int colIndex, int m, int n, int[][] matrix) {
        if(rowIndex == n || colIndex == m) return 0;
        else if(rowIndex == n-1 && colIndex == m-1) {
            matrix[rowIndex][colIndex] = 1;
            return 1;
        } else if(matrix[rowIndex][colIndex] > 0) return matrix[rowIndex][colIndex];
        int val = recurse(rowIndex+1, colIndex, m, n, matrix) + recurse(rowIndex, colIndex+1, m, n, matrix);
        matrix[rowIndex][colIndex] = val;
        return val;
    }

    public static void main(String [] args) {
        int m = 20;
        int n = 15;
        Problem62 problem62 = new Problem62();
        int val = problem62.uniquePaths(m, n);
        System.out.println(val);
    }
}
