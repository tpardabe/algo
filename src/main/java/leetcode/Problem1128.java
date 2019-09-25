package leetcode;

class Problem1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] array = new int[10][10];
        int count = 0;
        for(int i = 0; i < dominoes.length; i++) {
            int x =  0;
            int y = 0;
            if(dominoes[i][0] < dominoes[i][1]) {
                x = dominoes[i][0];
                y = dominoes[i][1];
            } else{
                y = dominoes[i][0];
                x = dominoes[i][1];
            }
            count += array[x][y];
            array[x][y] += 1;
        }
        return count;
    }
}
