package leetcode;
class Problem6 {
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;
                int nextIndex = numRows * 2 -2;
        int count = 0;
        StringBuilder builder = new StringBuilder();
        int index = 0;
        int rowIndex = 0;
        int row = 0;
        boolean isRow = true;
        while(count < s.length()){
            if(row == 0 || row == numRows -1) {
                builder.append(s.charAt(index));
                index += nextIndex;
                if(index >= s.length()){
                    index = row + 1;
                    rowIndex +=1;
                    row++;
                }
            } else {
                builder.append(s.charAt(index));
                if(isRow) {
                    rowIndex = index;
                    index = index + 2*(numRows - (row+1));
                    isRow = false;
                } else {
                    index = rowIndex + nextIndex;
                    isRow = true;
                }
                if(index >= s.length()){
                    index = row + 1;
                    rowIndex =row + 1;
                    row++;
                    isRow = true;
                }

            }
            count++;
        }
        return builder.toString();
    }
}
