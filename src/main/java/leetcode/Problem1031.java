package leetcode;


class Problem1031 {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        return Math.max(findMax(A, L, M), findMax(A, M, L));
    }
    
    int findMax(int[] A, int L, int M) {
        int[] maxL = new int[A.length];
        int maxSoFar = 0;
        int maxCurrent = 0;
        int sumMax = 0;
        int i = 0;
        for(; i < L; i++) {
            maxCurrent += A[i];
        }
        maxL[i -1] = maxCurrent;
        maxSoFar = maxCurrent;
        for(; i< A.length -M; i++) {
            maxCurrent += (A[i] - A[i-L]);
            if(maxSoFar < maxCurrent) maxSoFar = maxCurrent;
            if(maxCurrent < 0) maxCurrent= 0; 
            maxL[i] = maxSoFar;
        }
        int[] maxM = new int[A.length];
        maxCurrent = 0;
        maxSoFar = 0;
        i = A.length-1;
        for(; i >= A.length -M; i--) {
            maxCurrent += A[i];
        }
        maxM[i+1] = maxCurrent;
        maxSoFar = maxCurrent;
        for(; i >= L; i--) {
            maxCurrent += (A[i] - A[i+M]);
            if(maxSoFar < maxCurrent) maxSoFar = maxCurrent;
            if(maxCurrent < 0) maxCurrent= 0; 
            maxM[i] = maxSoFar;
        }
        for(i = L-1; i < A.length -M; i++) {
            if(maxL[i] + maxM[i+1] > sumMax) sumMax = maxL[i] + maxM[i+1];
        }
        return sumMax;
    }
}
