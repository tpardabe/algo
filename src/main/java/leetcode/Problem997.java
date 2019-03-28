package leetcode;
import java.util.HashSet;
import java.util.Set;

public class Problem997 {

    public int findJudge(int N, int[][] trust) {
        int[] trustList = new int[N + 1];
        Set<Integer> map = new HashSet<>();
        for(int i = 0; i < trust.length; i++) {
            int judge = trust[i][1];
            map.add(trust[i][0]);
            trustList[judge] += 1;

        }
        int result = -1;
        for(int i = 1; i < trustList.length; i++) {
            if(trustList[i] == N-1 && !map.contains(i)) return i;
        }
        return result;
    }

    public static void main(String[]args) {
        int[][] trust = {};
        int N = 3;
        Problem997 problem997 = new Problem997();
        int result = problem997.findJudge(N, trust);
        System.out.println("result: "+ result);

    }
}
