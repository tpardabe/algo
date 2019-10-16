package leetcode;
class Problem1004 {
    public int longestOnes(int[] A, int K) {
        if(A.length == 0) return 0;
        LinkedList<Integer> zeroIndex = new LinkedList();
        int remain = K;
        int l =0;
        int r = 0;
        int maxSoFar = 0;
        int maxCur = 0;
        while(l < A.length && r < A.length) {
            if(A[r] == 0) {
                if(remain > 0) {
                    remain--;
                    maxCur++;
                    maxSoFar = Math.max(maxSoFar, maxCur);
                    r++;
                } else {
                    for(;remain == 0;l++) {
                        remain += A[l] == 0 ? 1 : 0;
                        maxCur--;
                    }
                }
            } else {
                maxCur++;
                maxSoFar = Math.max(maxSoFar, maxCur);
                r++;
            } 
        }
        return maxSoFar;
    }
}
