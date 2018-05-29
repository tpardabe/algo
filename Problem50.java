package leetcode;

public class Problem50 {
    public static void main(String[] args) {
        Problem50 problem50 =  new Problem50();
        System.out.println(problem50.myPow(0.00001d, 2147483647));
    }

    public double myPow(double x, int n) {
        double result = 1d;
        if(n >=0){
            while(n > 0){
                result = result * x;
                n--;
            }
            return result;
        } else {
            while(n < 0){
                result = result * x;
                n++;
            }
            return 1/result;
        }
    }
}
