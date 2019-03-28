package leetcode;

public class Problem29 {

    public static void main(String[] args) {
        Problem29 solution = new Problem29();
        System.out.println(solution.divide(3, 2));

    }

    public int divide(int dividend, int divisor) {
        int absX = Math.abs(dividend);
        int absY = Math.abs(divisor);
        boolean xIsMinus = dividend < 0 ? true : false;
        boolean yIsMinus = divisor < 0 ? true : false;
        if( (xIsMinus && yIsMinus) || (!xIsMinus && !yIsMinus)) {
            return divideNumbers(absX, absY, true);
        } else if(xIsMinus) {
            return divideNumbers(absX, divisor, false);
        } else {
            return divideNumbers(dividend, absY, false);
        }
    }
    public int divideNumbers(int dividend, int divisor, boolean isPositive) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        if(dividend < divisor) return 0;
        int result = 0;
        if(dividend <= 0) {
            if(isPositive == true) return 1;
            else return -1;
        }
        if(isPositive) {
            if(result == max) return max;
            result = divideNumbers(dividend - divisor, divisor, isPositive) + 1 ;

        }
        else {

            if(result == min) return min;
            result = divideNumbers(dividend - divisor, divisor, isPositive) - 1 ;
        }
        return result;
    }
}
