package leetcode;

class Problem50 {
    public double myPow(double x, int n) {
        double result = 1d;
        if(x == 1) return x;
        else if(x == -1 && n %2 == 0) return (-1)* x;
        else if(x == -1 && (n %2 == 1 || n %2 == -1)) return x;
        if(n >=0){
            while(n > 0){
                result = result * x;
                if(result == 0.0) return 0.0;
                n--;
            }
            return result;
        } else {
            while(n < 0){
                result = result * x;
                if(result == 0.0) return 0.0;
                n++;
            }
            return 1/result;
        }
    }
}
