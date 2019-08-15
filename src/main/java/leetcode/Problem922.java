package leetcode;

public class Problem922 {
    public int[] sortArrayByParityII(int[] A) {
        int i = A.length-2, j = 0;
        while(i >=0 && j < A.length) {
            if(j%2 == 1 && A[j] %2 == 0) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                i -=2;
            } else {
                j++;
            }
        }
        return A;
    }
}
