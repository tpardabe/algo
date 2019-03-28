package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem17 {

    public static void main(String[] args) {
        Problem17 problem17 =  new Problem17();
        List<String> list = problem17.letterCombinations("236");
        list.forEach(x -> System.out.println(x));
    }
    public List<String> letterCombinations(String digits) {
        List<String> result =  new ArrayList<>();
        if(digits == null || digits.isEmpty()) return result;
        recursion(digits, result,  "");
        return result;
    }

    public void recursion(String digits, List<String> result, String currentString){
        if(digits == null || digits.isEmpty()){
            result.add(currentString);
            return;
        }
        char currentChar = digits.charAt(0);
        char[] characters = getNumber(currentChar);
        for(int i = 0; i < characters.length; i++){
            recursion(digits.substring(1), result, currentString +characters[i]);
        }
    }
    private char[] getNumber(char currentChar) {
        char[][] list = new char[][]{
                {' '},
                {},
                { 'a', 'b', 'c'},
                { 'd', 'e', 'f'},
                { 'g', 'h', 'i'},
                { 'j', 'k', 'l'},
                { 'm', 'n', 'o'},
                { 'p', 'q', 'r', 's'},
                { 't', 'u', 'v'},
                { 'w', 'x', 'y', 'z'},
                {'+'},
        };
        if(currentChar == '*') return list[10];
        else{
            return list[currentChar-'0'];
        }
    }
}
