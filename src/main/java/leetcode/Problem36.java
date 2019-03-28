package leetcode;
public class Problem36 {
    public static void main(String [] args) {
        Problem36 solution = new Problem36();
        solution.solve();

        /***
         * [[".",".","4",".",".",".","6","3","."],
         * [".",".",".",".",".",".",".",".","."],
         * ["5",".",".",".",".",".",".","9","."],
         * [".",".",".","5","6",".",".",".","."],
         * ["4",".","3",".",".",".",".",".","1"],
         * [".",".",".","7",".",".",".",".","."],
         * [".",".",".","5",".",".",".",".","."],
         * [".",".",".",".",".",".",".",".","."],
         * [".",".",".",".",".",".",".",".","."]]
         */
    }
    public void solve(){
        char[][] input = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'6','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(input));
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[][] table = new boolean[board.length][board[0].length + 1];
        boolean[][] rows = new boolean[board.length][board[0].length + 1];
        boolean[][] columns = new boolean[board.length + 1][board[0].length];
        int i = 0;//0|3|6
        int j = 0;//0|3|6
        int counter = 0;
        int row = 0;
        while(i < board.length && j < board[0].length) {
            char current = board[j][i];
            if(current != '.') {
               int number = current - '0';
               if(table[row][number] == true) return false;
               if(rows[j][number] == true) return false;
               if(columns[number][i] == true) return false;
               table[row][number] = true;
               rows[j][number] = true;
               columns[number][i] = true;
            }
            i++;
            counter++;
            if(i == 3 && counter < 9) {//going to 1 box column
                i = 0;
                j++;
            } else if(i == 6 && counter < 9) {//going to 2 box column
                i = 3;
                j++;
            } else if(i == 9 && counter < 9) {//going to 3 box column
                i = 6;
                j++;
            }
            if(counter == 9) {
                if(j == 2 && i < 9) j = 0;
                else if(j == 5 && i < 9) j = 3;
                else if(j == 8 && i < 9) j = 6;
                else if(j < 9){
                    j++;
                    i = 0;
                }
                row++;
                counter = 0;
            }

        }
        return true;
    }
}
