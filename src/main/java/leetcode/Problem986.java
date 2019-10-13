package leetcode;

class Problem986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int l = 0;
        int r = 0;
        List<List<Integer>> result = new ArrayList();
        while(l < A.length && r < B.length) {
            List<Integer> tmp = new ArrayList();
            boolean add = false;
            if(A[l][0] >= B[r][0] && A[l][0] <= B[r][1]) {
                tmp.add(A[l][0]);
                add = true;
            } else if(B[r][0] >= A[l][0] && B[r][0] <= A[l][1]) {
                tmp.add(B[r][0]);
                add = true;
            }
            if(A[l][1] >= B[r][0] && A[l][1] <= B[r][1]) {
                tmp.add(A[l][1]);
                add = true;
            }  else if(B[r][1] >= A[l][0] && B[r][1] <= A[l][1]) {
                tmp.add(B[r][1]);
                add = true;
            } 
            if(add) {
                result.add(tmp);
            }
            if(B[r][1] < A[l][1]) r++;
            else l++;
        }
        int[][] array = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++) {
            array[i][0] = result.get(i).get(0);
            array[i][1] = result.get(i).get(1);
        }
        return array;
    }
}
