package leetcode;

public class Problem766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int numberOfDiaganals = matrix.length + matrix[0].length - 1;
        int row = matrix.length - 1;
        int column = 0;
        int currentRow = row;
        int currentColumn = column;
        for(int i = 0; i < numberOfDiaganals; i++) {
            int number = matrix[row] [column];
            while(row < matrix.length && column < matrix[0].length) {
                if(number != matrix[row++] [column++]) return false;
            }
            if(currentRow > 0) {
                currentRow -= 1;
                currentColumn = 0;
            } else {
                currentColumn += 1;
                currentRow = 0;
            }
            row = currentRow;
            column = currentColumn;
        }
        return true;
    }
}
