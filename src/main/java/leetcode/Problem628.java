package leetcode;

class Problem628 {
    public int maximumProduct(int[] nums) {
        int firstNum = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        int theSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for(int num: nums) {
            if(num > firstNum) {
               third = second;
                second = firstNum;
                 firstNum = num;
            } else if(num > second) {
                third = second;
                second = num;
            } else if(num > third) {
                third = num;
            }
            if(num < 0 && num < theSmallest) {
                 secondSmallest = theSmallest;
                theSmallest = num;
            } else if(num < 0 && num < secondSmallest) {
                secondSmallest = num;
            }
        }
        int sum = firstNum;
        if(theSmallest != Integer.MAX_VALUE && secondSmallest != Integer.MAX_VALUE ) {
            if(theSmallest * secondSmallest > second * third) {
                sum *= (theSmallest * secondSmallest);
            } else {
                sum *= (second * third);
            }
        } else {
             sum *= (second * third);
        }
        return sum;
    }
}
