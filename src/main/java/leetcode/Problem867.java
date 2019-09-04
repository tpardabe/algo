package leetcode;

public class Problem867 {
    public int[][] transpose(int[][] A) {
        if(A == null || A.length == 0) return null;
        int[][] result = new int[A[0].length][A.length];
        int row = A[0].length;
        int column = A.length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                result[i][j] = A[j][i];
            }
        }
        return result;
    }
}
