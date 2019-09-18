package leetcode;

class Problem566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if((nums == null) || (nums.length * nums[0].length != r*c))return nums;
        int[][] result = new int[r][c];
        int i = 0;
        int j = 0;
        int a = 0;
        int k = 0;
        while(i < nums.length && j < nums[0].length) {
            result[a][k] = nums[i][j];
            j++;
            if(j == nums[0].length) {
                j = 0;
                i++;
            }
            k++;
            if(k == c) {
                k = 0;
                a++;
            }
        }
        return result;
    }
}
