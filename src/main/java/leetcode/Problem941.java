package leetcode;

class Problem941 {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int prev = A[0], i = 1;
        boolean increasing = false;
        boolean decreasing = false;
        while(!decreasing && i < A.length) {
            if(prev >= A[i]) decreasing = true;
            prev = A[i];
        }
        for (; i < A.length && prev < A[i]; i++) {
            prev = A[i];
        }
        for (; i < A.length && prev > A[i]; i++) {
            prev = A[i];
        }

    }
}
