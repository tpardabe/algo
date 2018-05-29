package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem67 {

    public static void main(String[] args ){
        Problem67 solution = new Problem67();
        solution.solve();
    }

    public void solve(){
        System.out.println(addBinary( "11","11"));
    }

    public String addBinary(String a, String b) {
        StringBuilder reversedList = new StringBuilder();
        StringBuilder result  = new StringBuilder();
        int lengthA = a.length();
        int lengthB = b.length();
        if(lengthA > lengthB) {
            get(reversedList, a, b);
        } else {
            get(reversedList, b,a);
        }
        String reversed = reversedList.toString();
        for(int i = reversed.length()-1; i >= 0; i--) {
            result.append(reversed.charAt(i));
        }
        return result.toString();
    }

    public void get(StringBuilder reversedList, String a, String b){
        int excess = 0;
        int j = b.length()-1;
        for(int i = a.length()-1; i >=0; i--){
            int numberA = a.charAt(i) - '0';
            if(j >=0) {
                reversedList.append((numberA + (b.charAt(j) - '0') + excess) %2);
                excess = (numberA + (b.charAt(j--) - '0') + excess) /2;
            } else {
                reversedList.append((numberA + excess) %2);
                excess = (numberA + excess) /2;
            }
        }
        while(excess > 0){
            reversedList.append(excess%2);
            excess = excess/2;
        }
    }
}
