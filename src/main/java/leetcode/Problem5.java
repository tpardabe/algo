package leetcode;

import javafx.util.Pair;

public class Problem5 {


    public static void main(String[]args ) {
        Problem5 solution = new Problem5();
        System.out.println(solution.longestPalindrome("aba"));
    }

    public String longestPalindrome(String s) {
        String longestPolindrome = "";
        if(s.isEmpty()) return longestPolindrome;
        int left = 0;
        int right = 0;
        int longest = 0;
        for(int i = 0; i < s.length(); i++) {
            Pair k = getPalindrome(s, i, i);
            if(((int)k.getValue() - (int)k.getKey()-0 + 1) > longest) {
                left = (int)k.getKey();
                right = (int)k.getValue();
                longest = right - left-0 +1;
            }
            Pair c = getPalindrome(s, i, i+1);
            if(((int)c.getValue() - (int)c.getKey()-0 + 1) > longest) {
                left = (int)c.getKey();
                right = (int)c.getValue();
                longest = right - left-0 +1;
            }
        }
        return s.substring(left, right +1);
    }

    public Pair getPalindrome(String str, int left, int right) {
        String result = "";
        while(left >= 0 && right < str.length()) {
            if(str.charAt(left) != str.charAt(right)){
                new Pair(0, 0);
                break;
            }
            left--;
            right++;
        }
        return new Pair(left + 1, right - 1);
    }






    /*public String longestPalindrome(String s) {
        String result = s.substring(0, 1);
        for(int i = 1; i <= s.length(); i++ ) {
            int startIndex = 0 ;
            int endIndex = s.length() - i;
            for(int c = 1; c <= i && endIndex < s.length() && startIndex < s.length(); c++) {
                if (isPalindrome(s, startIndex, endIndex)) {
                    return s.substring(startIndex, endIndex+1);
                }
                startIndex++;
                endIndex++;
            }
        }
        return result;
    }

    public boolean isPalindrome (String s, int startIndex, int endIndex) {
        int i = startIndex;
        int j = endIndex;
        while(i <= j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }*/
}
