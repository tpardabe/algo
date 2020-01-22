package leetcode;

class Problem1239 {
    int max;
    int[] array;
    public int maxLength(List<String> arr) {
        max = 0;
        array = new int[26];
        dfs(new StringBuilder(), arr, 0);
        return max;
    }
    
    void dfs(StringBuilder builder, List<String> arr, int start) {
        max = Math.max(max, builder.toString().length());
        for(int i = start; i < arr.size(); i++) {
            if(valid(arr.get(i))) {
                builder.append(arr.get(i));
                dfs(builder, arr, i + 1);
                substract(arr.get(i).toCharArray());
                builder.setLength(builder.length() - arr.get(i).length());
            }
        }
    }
    
    boolean valid(String s) {
        char[] x = s.toCharArray();
        boolean valid = true;
        for(char ch: x) {
            if(array[ch-'a'] > 0) valid = false;
            array[ch-'a']++;
        }
        if(!valid) substract(x);
        return valid;
    }
    
    void substract(char[] x) {
        for(char ch: x) array[ch-'a']--;
    }
}
