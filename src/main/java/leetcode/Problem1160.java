package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem1160 {

    public static int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < chars.length(); i++) {
            if(!map.containsKey(chars.charAt(i))) {
                map.put(chars.charAt(i), 0);
            }
            map.put(chars.charAt(i), map.get(chars.charAt(i)) +1);
        }
        int count = 0;
        for(int i = 0; i < words.length; i++) {
            int[] characters = new int[26];
            boolean notSubstring = false;
            for(int j =0 ; j < words[i].length(); j++) {
                int index = words[i].charAt(j) - 97;
                characters[index] += 1;
                if(!map.containsKey(words[i].charAt(j)) || map.get(words[i].charAt(j)) < characters[index]) {
                    notSubstring = true;
                    break;
                }
            }
            if(!notSubstring) {
                count +=words[i].length();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words = {"hello","world","leetcode"};
        System.out.println(countCharacters(words, "welldonehoneyr"));
    }
}
