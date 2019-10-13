package leetcode;

class Problem763 {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for(int i = 0; i < S.length(); i++) last[S.charAt(i) - 'a'] = i;
        List<Integer> result = new ArrayList();
        int l = 0;
        int r = 0;
        int count = 0;
        while(l < S.length() && r < S.length()-1) {
            r = Math.max(last[S.charAt(l) - 'a'], r);
            count++;
            if(r == S.length()-1 || r == l) {
                result.add(r - l + count);
                count = 0;
            }
            l++;
        }
        return result;
    }
}
