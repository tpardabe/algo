package leetcode;

class Problem118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        if(numRows == 0) return result;
        List<Integer> list = new ArrayList();
        list.add(1);
        result.add(list);
        for(int i = 1; i < numRows; i++) {
            list = new ArrayList();
            list.add(1);
            for(int j = i; j > 1; j--) {
                list.add(result.get(i-1).get(j-1) + result.get(i-1).get(j-2));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }
}
