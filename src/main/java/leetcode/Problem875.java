package leetcode;


class Problem875 {
    public int minEatingSpeed(int[] piles, int H) {
        Arrays.sort(piles);
        int lo = 1;
        int hi = piles[piles.length - 1];
        int minimum  = -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            int count = count(mid, piles);
            if(count <= H) {
                minimum = mid;
                hi = mid - 1;
            } else lo = mid +1;
        }
        return minimum;
    
    }
    
    int count(int number, int[] piles) {
        int count = 0;
        for(int num: piles) {
            int increment = 0;
            if(number > num) increment = 1;
            else if(num % number > 0) increment =  (num/number) +1;
            else increment = num/number;
            count +=increment;
        }
        return count;
    }
}
