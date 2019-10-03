package leetcode;


class Problem119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList();
        for(int i = 0; i <= rowIndex; i++) {
            result.add(1);
        }
        int end = 0;
        for(int i = rowIndex; i > 0; i--) {
            calc(result, ++end);
        }
        return result;
    }
    
    private void calc(List<Integer> list, int end) {
        for(int i = list.size() -2; i >= end; i--) {
            list.set(i, list.get(i) + list.get(i + 1));
        }
    }
}
