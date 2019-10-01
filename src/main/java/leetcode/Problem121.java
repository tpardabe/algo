package leetcode;


class Problem121 {
    public int maxProfit(int[] prices) {
        int maxSoFar = 0;
        int currentMax = 0;
        for(int i = 0; i < prices.length-1; i++) {
            currentMax += (prices[i+1] - prices[i]);
            if(maxSoFar < currentMax) maxSoFar = currentMax;
            if(currentMax <0) currentMax = 0;
        }
        return maxSoFar;
    }
}
