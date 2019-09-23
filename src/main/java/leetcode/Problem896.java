package leetcode;


class Problem896 {
    public boolean isMonotonic(int[] A) {
        if(A.length == 0) return true;
        int increasing = 0;
        int prev = A[0];
        for(int current: A) {
            if(prev != current) {
                if(increasing == 0) {
                    increasing = (current > prev) ? 1 : -1;
                } else if((increasing < 0 && current > prev) || (increasing > 0 && current < prev)){
                    return false;
                }
            }
            prev = current;
        }
        return true;
    }
}
