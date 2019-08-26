package leetcode;

class Problem999 {
    public int numRookCaptures(char[][] board) {
        int colIndex = 0;
        int rowIndex = 0;
        boolean found = false;
        for(int i =0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(board[i][j] == 'R') {
                    colIndex = j;
                    rowIndex = i;
                    found = true;
                }
            }
            if(found) break;
        }
        int count = 0;
        for(int i = 0; i < 4; i++) {
            if(i == 0) {
                count += getCapture(rowIndex, colIndex, 0, -1, board);
            } else if(i == 1) {
                count += getCapture(rowIndex, colIndex, -1, 0, board);
            } else if(i == 2) {
                count += getCapture(rowIndex, colIndex, 0, 1, board);
            } else {
                count += getCapture(rowIndex, colIndex, 1, 0, board);
            }
        }
        return count;
    }
    
    private int getCapture(int rowIndex, int columnIndex, int rowIncrement, int columIncrement, char[][] board) {
        if(rowIncrement != 0) {
            for(int i = rowIndex; (i < 8) && (i >=0);) {
                char current = board[i][columnIndex];
                if(current ==  'p') {
                    return 1;
                }
                else if((current == 'r' ) ||
                        (Character.toUpperCase(current) == 'B') ||
                       (current == 'P')) return 0;
                i +=rowIncrement;
            }
        } else {
            for(int i = columnIndex; (i < 8) && (i >=0);) {
                char current = board[rowIndex][i];
                if(current ==  'p') return 1;
                else if((current == 'r' ) ||
                        (Character.toUpperCase(current) == 'B') ||
                       (current == 'P')) return 0;
                i +=columIncrement;
            }
        }
        return 0;
    }
}
