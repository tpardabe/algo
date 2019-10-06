package leetcode;

class Problem830 {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList();
        int count = 1;
        int prev = 0;
        for(int i = 1; i < S.length(); i++) {
            if(S.charAt(i - 1) == S.charAt(i)) {
                count++;
                if(i == S.length() - 1 && count >2) {
                    List<Integer> tmp = new ArrayList();
                    tmp.add(prev);
                    tmp.add(i);
                    result.add(tmp);
                }
            } else {
                if(count >2 ) {
                    List<Integer> tmp = new ArrayList();
                    tmp.add(prev);
                    tmp.add(i-1);
                    result.add(tmp);
                }
                count = 1;
                prev =i;
            }
        }
        return result;
    }
}
