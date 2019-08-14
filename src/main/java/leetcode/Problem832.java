package leetcode;

public class Problem832 {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A == null || A.length == 0) return null;
        int[][] result = new int[A.length][A[0].length];
        for(int k = 0; k < A.length; k++) {
            int i = 0;
            int j = A[k].length-1;
            result[k] = new int[A[k].length];
            while(i < j) {
                int tmp = A[k][i] ^ 1;
                result[k][i++] = A[k][j] ^ 1;
                result[k][j--] = tmp;
            }
            if(i == j) {
                result[k][i] = A[k][i] ^ 1;
            }
        }
        return result;
    }
}
