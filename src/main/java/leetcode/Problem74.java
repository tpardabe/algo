package leetcode;

public class Problem74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int sizeVertical = matrix.length;
        if(matrix == null || sizeVertical == 0) return false;
        int right = (matrix.length -1) * matrix[0].length + matrix[0].length -1;
        return binarySearch(target, matrix, 0, right);
    }

    private boolean binarySearch(int target, int[][] matrix, int left, int right) {
        if(left > right) return false;
        else {
            int middle = left + (right - left)/2;
            int row = middle / matrix[0].length;
            int column = middle % matrix[0].length;
            int value = matrix[row][column];
            if(value == target) return true;
            else if(target > value) return binarySearch(target, matrix, middle +1, right);
            else return binarySearch(target, matrix, left, middle -1);
        }
    }
}
