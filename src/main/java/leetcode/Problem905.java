package leetcode;
class Problem905 {
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int index = 0;
        for(int i = 0;i < A.length; i++) {
            if(A[i]%2 == 0) result[index++] = A[i];
        }
        for(int i = 0;i < A.length; i++) {
            if(A[i]%2 == 1) result[index++] = A[i];
        }
        return result;
    }
}
