package leetcode;

class Problem1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        
        for(int i = 1; i < arr.length; i++) {
            arr[i] ^= arr[i - 1];
        }
        
        for(int i = 0; i < queries.length; i++) {
            result[i] = (queries[i][0] > 0) ? arr[queries[i][0] - 1] ^ arr[queries[i][1]] : arr[queries[i][1]];
        }
        return result;
        //NOTE: A ^ A ^ B = B
    }
}
