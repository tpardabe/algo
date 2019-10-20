package leetcode;

class Problem930 {
    public int numSubarraysWithSum(int[] A, int S) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int remain = S;
        int zLeading = 0;
        int zTrailing = 0;
        while(r < A.length) {
            if(A[r] == 1)  {
                if(remain > 0) {
                    remain--;
                    r++;
                } else {
                    zLeading = 0;
                    while(A[l] == 0) {
                        zLeading ++;
                        l++;
                    }
                    sum += (zLeading +1) * (zTrailing +1);
                    for(; remain == 0; l++) {
                        if(A[l] == 1) remain ++;
                    }
                }
                zTrailing = 0;
            } else {
                zTrailing++;
                r++;
            }
        }
        if(remain == 0) {
            zLeading = 0;
            while(l < A.length && A[l] == 0) {
                zLeading ++;
                l++;
            }
            sum += (zLeading +1) * (zTrailing +1);
        }
        if(S == 0) {
            sum = 0;
            int  i =0;
            int count = 0;
            while(i < A.length) {
                if(A[i] == 0) count++;
                else {
                    sum += (count * (1+ count)/2);
                    count= 0;
                }
                i++;
            }
            sum += (count * (1+ count)/2);
        }
        return sum;
    }
}
