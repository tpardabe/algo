class Problem48 {
    public void rotate(int[][] matrix) {
        int i = 0;
        int j = matrix.length-1;
        int corner =1;
        int value = 0;
        int counter = 0;
        while(j>i) {//j >= matrix.length/2 && i<=matrix.length/2
            if(corner == 1) {
                int tmp = matrix[i][i+counter];
                matrix[i][i+counter] = matrix[j][i];
                value = tmp;
                corner = 2;
            } else if(corner == 2) {
                int tmp = matrix[i + counter][matrix.length -1 - i];
                matrix[i + counter][matrix.length -1 - i] = value;
                value = tmp;
                corner = 3;
            } else if(corner == 3) {
                int tmp = matrix[matrix.length -1 - i][matrix.length -1 - i- counter];
                matrix[matrix.length -1 - i][matrix.length -1 - i- counter] = value;
                value = tmp;
                corner = 4;
            } else {
                matrix[matrix.length -1 - i-counter][i] = value;
                value = 0;
                j--;
                counter++;
                corner = 1;
            }
            if((j== 0 && i ==0) || j== i){
                i++;
                counter = 0;
                j= matrix.length-1 -i;
            }
        }
    }
}
