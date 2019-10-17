package leetcode;


class Problem345 {
    public String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int l = 0;
        int r = word.length - 1;
        boolean[] reversed = new boolean[word.length];
        while(l < word.length && r >=0) {
            if(isVowel(word[l]) && !reversed[l] && isVowel(word[r])) {
                char tmp = word[l];
                reversed[l] = true;
                reversed[r] = true;
                word[l++] = word[r];
                word[r--] = tmp;
            } else if(!isVowel(word[l]))  l++;
            else r--;
        }
        StringBuilder builder = new StringBuilder();
        for(char ch: word) builder.append(ch);
       return builder.toString();
    }
    private boolean isVowel(char a) {
        if(a == 'a' || a == 'A') return true;
        else if(a == 'e' || a == 'E') return true;
        else if(a == 'i' || a == 'I') return true;
        else if(a == 'o' || a == 'O') return true;
        else if(a == 'u' || a == 'U') return true;
        else return false;
    }
}
