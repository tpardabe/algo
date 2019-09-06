package leetcode;

public class Problem985 {
    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        int[] array = new int[queries.length];
        for(int i = 0; i < A.length; i++) if(A[i] %2 ==0) sum += A[i];
        for(int i = 0; i < queries.length; i++) {
            if (A[queries[i][1]] % 2 == 0 && queries[i][0] % 2 != 0) sum = sum - A[queries[i][1]];
            else if(A[queries[i][1]] % 2 == 0 && queries[i][0] % 2 == 0)sum += queries[i][0];
            else if(A[queries[i][1]] % 2 != 0 && queries[i][0] % 2 != 0) sum = sum + queries[i][0] + A[queries[i][1]];
            array[i] = sum;
            A[queries[i][1]] += queries[i][0];
        }
        return array;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
        int[] result = sumEvenAfterQueries(A, queries);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
