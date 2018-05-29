package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {

    public static void main(String[] args) {
        Problem3 solution = new Problem3();
        System.out.println(solution.lengthOfLongestSubstring("abba"));
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        int size = s.length();
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        int currentMax = 0;
        String ch = "";
        char prevChar = '0';
        for(int i = 0; i < size; i++){
            ch = s.charAt(i) +"";
            if(map.containsKey(ch)) {
                if(prevChar == s.charAt(i))
                    currentMax = 1;
                max = Math.max(max, currentMax);
                System.out.println(ch +" "+ currentMax);
                continue;
            }
            /*if(map.containsKey(ch)){
                max = Math.max(max, map.size());
                i = map.get(ch)-1;
                map =  new HashMap<>();
                continue;
            }*/
            currentMax += 1;
            prevChar = s.charAt(i);
            max = Math.max(max, currentMax);
            System.out.println(ch +" "+ currentMax);
            map.put(ch, currentMax);
        }
        max = Math.max(max, map.get(ch));
        return max;
    }
}
