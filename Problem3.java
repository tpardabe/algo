package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();
        Map map = new HashMap();
        int max = 0;
        int tmpMax = 0;
        int startIndex =  0;
        for(int i = 0; i < s.length(); i ++) {
            char current = s.charAt(i);
            if(map.containsKey(current) && (Integer)map.get(current) >= startIndex) {
                tmpMax = i- (Integer)map.get(current);
                startIndex = (Integer)map.get(current) +1;
            } else {
                tmpMax++;
            }
            map.put(current, i);
            max = Math.max(tmpMax, max);
        }
        return max;
    }
}
