package leetcode;

class Problem122 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int i = 0 ;
        int prevIndex = 0;
        while(i < prices.length) {
            while(i +1 < prices.length && prices[i] < prices[i +1]) {
                if(i + 2 ==  prices.length || prices[i +1] >= prices[i + 2]) {
                    sum += (prices[i + 1] - prices[prevIndex]);
                }
                i++;
            }
            while(i + 1 < prices.length && prices[i] >= prices[i +1]) prevIndex = ++i;
            if(i +1 == prices.length) i++;
        }
        return sum;
    }
}
