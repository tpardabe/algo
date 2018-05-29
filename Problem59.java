package leetcode;

public class Problem59 {

    public static void main(String[] args) {
        Problem59 problem59 = new Problem59();
        int[][] num = problem59.generateMatrix(1);
        for(int i = 0; i < num.length; i++) {
            for(int number: num[i]) {
                System.out.print(number);
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] result =  new int[n][n];
        int dir = 0;
        int left   = 0;
        int right  = n-1;
        int top    = 0;
        int bottom = n-1;
        int currentNum = 1;
        while(left <=right && top <= bottom) {
            if(dir == 0) {
                for(int i = left; i <=right; i++){
                    result[top][i] = currentNum++;
                }
                dir = 1;
                top++;
            } else if(dir == 1){
                for(int i = top; i <=bottom; i++){
                    result[i][right] = currentNum++;
                }
                dir = 2;
                right--;
            } else if(dir == 2) {
                for(int i = right; i >=left; i--){
                    result[bottom][i] = currentNum++;
                }
                dir = 3;
                bottom--;
            } else {
                for(int i = bottom; i >=top; i--){
                    result[i][left] = currentNum++;
                }
                dir = 0;
                left++;
            }

        }
        return result;
    }
}
