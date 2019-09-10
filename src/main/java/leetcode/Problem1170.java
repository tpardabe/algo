package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] result = new int[queries.length];
        List<Integer> wordFrequency = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            wordFrequency.add(frequency(words[i]));
        }
        Collections.sort(wordFrequency);
        for(int i = 0; i < queries.length; i++) {
            int frequent = frequency(queries[i]);
            result[i] = getGreater(wordFrequency, frequent);
        }
        return result;
    }

    private int frequency(String s) {
        if(s.isEmpty()) return 0;
        char[] array = s.toCharArray();
        Arrays.sort(array);
        int count = 1;
        char current = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] != current) return count;
            count++;
        }
        return count;
    }

    private int getGreater(List<Integer > list, int number) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) > number) return list.size() - (i+1);
        }
        return 0;
    }
}
