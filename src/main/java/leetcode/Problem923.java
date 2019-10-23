package leetcode;

class Problem923 {
    Map<Integer, Integer> map = new HashMap();
    long division = (long)Math.pow(10,9) + 7L;
    long max = (long)Integer.MAX_VALUE;
    public int threeSumMulti(int[] A, int target) {
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap();
        for(int num: A) {
            if(!map.containsKey(num)) map.put(num, 0);
            map.put(num, map.get(num) + 1);
        }
        int count = 0;
        for(int i = 0; i < A.length -2; i++) {
            int l = i+1;
            int r = A.length -1;
            while(l < r) {
                int sum = A[i] + A[l] + A[r];
                if(sum == target) {
                    int occur = map.get(A[r]);
                    if(A[r] == A[l]) {
                        int k = (A[i] == A[l]) ? 3 : 2;
                        count += binomial(occur, k);
                        i += (A[i] == A[l]) ? occur -1 : 0;
                        l += occur;
                    } else {
                        count += occur;
                        l++;
                    }
                } else if(sum < target) l++;
                else r--;
            }
        }
        return count;
    }
    private int binomial(int number, int k) {
        int count = k;
        long num = 1L;
        while(count-- > 0) {
            num *= number;
            number--;
        }
        int coef = factorial(k);
        long res =  num / coef;
        if(res > max) {
            res = res % division;
        }
        return (int)res;
    }
    private int factorial(int n) {
        if(n <= 1) return 1;
        else if(map.containsKey(n)) return map.get(n);
        int result = n * factorial(n-1);
        map.put(n, result);
        return result;
    }
}
