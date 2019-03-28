package leetcode;

public class Problem66 {
    public static void main(String[] args ){
        Problem66 solution = new Problem66();
        solution.solve();
    }

    public void solve(){
        int[] digits = {9, 9};
        int[] result = plusOne(digits);
        for(int number : result) {
            System.out.print(number);
        }
    }

    public int[] plusOne(int[] digits) {
        int excess = 1;
        int[] result =  new int[digits.length];
        for(int i= digits.length-1; i >= 0; i--) {
            result[i] = (digits[i] + excess)% 10;
            excess = (digits[i] + excess) / 10;
        }
        if(excess > 0) {
            int[] newResult =  new int[digits.length + 1];
            newResult[0] = excess;
            for(int i = 0; i < result.length; i++) newResult[i+1] = result[i];
            result = newResult;
        }
        return result;
    }
}
