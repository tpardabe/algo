package leetcode;

class Problem1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList();
        int current = 0;
        for(int i = 0; i < A.length; i++) {
            current = (current * 2) % 5 + A[i];
            result.add(current % 5 == 0);
        }
        return result;
    }
}
