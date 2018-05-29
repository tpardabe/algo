package leetcode;

public class Problem69 {

    public static void main(String[] args) {
        Problem69 problem69 = new Problem69();
        System.out.println(problem69.mySqrt(Integer.MAX_VALUE));
    }

    public int mySqrt(int x) {
        if(x == 0) return 0;
        return recurse(x, 1, x, 0);
    }

    private int recurse(int number, int left, int right, int ans) {
        if(left > right ) return ans;
        int middle = left + (right - left)/2;
        /*int sqr = middle * middle;*/
        if(middle == number/middle) return middle;
        else if(middle < (number/middle))return recurse(number, middle+1, right, middle);
        else return recurse(number, left, middle-1, ans);
    }
}
