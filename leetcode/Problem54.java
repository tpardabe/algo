package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem54 {

    public static void main(String[] args) {
        spiralOrder(new int[0][0]);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result  = new ArrayList<>();
        if(matrix == null || matrix.length  == 0) return result;
        int left = 0 ;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int top = 0;
        int dir = 0;
        while(left <= right && top <= bottom) {
            if(dir == 0) {
                for(int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
                dir = 1;
            } else if(dir == 1) {
                for(int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
                dir =2;
            } else if(dir == 2) {
                for(int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
                dir =3;
            } else {
                for(int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
                dir = 0;
            }
        }
        return result;
    }
}
