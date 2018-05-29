package leetcode;

public class Problem9 {
    public static void main(String[]args) {
        Problem9 solution = new Problem9();
        System.out.println(solution.isPalindrome(12));
    }

    public boolean isPalindrome(int x) {
        String value = String.valueOf(x);
        return isPalindrome(value);
    }

    public boolean isPalindrome(String x) {
        int i = 0;
        int j = x.length()-1;
        while (i <= j) {
            if(x.charAt(i) != x.charAt(j)) return false;
            i ++;
            j--;
        }
        return true;
    }
}
