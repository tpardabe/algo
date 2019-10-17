package leetcode;

class Problem524 {
    public String findLongestWord(String s, List<String> d) {
        char[] word = s.toCharArray();
        int index = -1;
        Collections.sort(d);
        for(int i = 0; i < d.size(); i++) {
            int left = 0;
            int right = word.length - 1;
            int l = 0;
            int r = d.get(i).length() - 1;
            String dicWord = d.get(i);
            while(l <= r && left <= right) {
                if(word[left] == dicWord.charAt(l)) {
                    left++;
                    l++;
                } else if(word[right] == dicWord.charAt(r)) {
                    right--;
                    r--;
                } else {
                    left++;
                }
            }
            if(l > r){
                if(index == -1) index = i;
                else if(d.get(index).length() < dicWord.length()) {
                    index = i;
                }
            }
        }
        if(index == -1) return "";
        else return d.get(index);
    }
}
