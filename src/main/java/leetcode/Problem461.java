package leetcode;

class Problem461 {
    public int hammingDistance(int x, int y) {
        int xor =x ^ y;
        int res = 0;
        while(xor > 0) {
            int pos = xor & 1;
            if(pos == 1) res++;
            xor = xor >> 1;
        }
        return res;
    }
}
