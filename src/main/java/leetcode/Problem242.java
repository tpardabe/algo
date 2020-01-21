package leetcode;

class Problem242 {
    public boolean isAnagram(String s, String t) {
        int[] array = new int[26];
        for(char ch: s.toCharArray()) {
            array[ch - 'a']++;
        }
        for(char ch: t.toCharArray()) {
            if(array[ch - 'a'] == 0) return false; 
            array[ch - 'a']--;
        }
        
        for(int i = 0; i < 26; i++) {
            if(array[i] > 0) return false;
        }
        return true;
    }
}
