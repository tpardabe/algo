package leetcode;

class Problem931 {
    
    public int minFallingPathSum(int[][] A) {
        for(int i = A.length - 2; i >= 0 ; i--) {
            for(int j = 0; j < A[i].length; j++) {
                int prevA = (j == 0) ? Integer.MAX_VALUE : A[i +1][j - 1];
                int prevB = A[i +1][j];
                int prevC = (j == A[i].length - 1)? Integer.MAX_VALUE : A[i+ 1][j+1];
                int prevMin = min(prevA, prevB, prevC);
                A[i][j] += prevMin;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < A[0].length; i++) {
            min = Math.min(min, A[0][i]);
        }
        return min;
    }
    
    int min(int a, int b, int c) {
        int min = (int)Math.min(a, b);
        min = (int) Math.min(min, c);
        return min;
    }
}
