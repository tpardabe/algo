package leetcode;

class Problem845 {
    public int longestMountain(int[] A) {
        if(A.length == 0) return 0;
        int l = 0;
        int r = 1;
        int count = 0;
        while(r < A.length) {
            boolean increasing = false;
            boolean decreasing = false;
            for(; r < A.length && A[r] > A[r - 1]; r++) increasing = true;
            for(; r < A.length && A[r] < A[r - 1]; r++) decreasing = true;
            if(increasing && decreasing) count = Math.max(count, r - l);
            while(r < A.length && A[r] == A[r - 1] ) {
                r++;
            }
            l = r - 1;
        }
        return count;
    }
}
