package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem1002 {
    public static List<String> commonChars(String[] A) {
        if(A == null && A.length == 0) return null;
        List<String> result = new ArrayList();
        int[] common = new int[26];
        for(int i = 0; i < A[0].length(); i++) {
            common[A[0].charAt(i) - 'a'] +=1;
        }
        int[] string = null;
        for(int i = 1; i < A.length; i++) {
            string = new int[26];
            for(int j = 0; j < A[i].length(); j++) {
                string[A[i].charAt(j) - 'a'] +=1;
            }
            for(int j = 0; j < 26; j++) {
                if(common[j] > string[j]) {
                    common[j] = string[j];
                }
            }
        }
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < common[i]; j++) {
                result.add(String.valueOf((char)(97 + i)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] A = {"cool","lock","cook"};
        List<String> list = commonChars(A);
        for(String a: list) {
            System.out.println(a);
        }
    }
}
