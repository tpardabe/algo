package leetcode;
class Problem888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sum1 = 0;
        int sum2 = 0;
        Set set2 = new HashSet();
        int [] ans = new int[2];
        for(int i = 0; i < A.length; i++)  sum1 +=A[i];
        for(int i = 0; i < B.length; i++) {
            sum2 +=B[i];
            set2.add(B[i]);
        }
        int avg = (sum1 + sum2) / 2;
        int diff = sum2 - avg;
        for(int i = 0; i < A.length; i++) {
            if(set2.contains(A[i]  + diff )) {
                ans[0] = A[i];
                ans[1] = A[i] + diff;
                break;
            }
        }
        return ans;
    }
}
