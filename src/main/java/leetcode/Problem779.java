package leetcode;

class Problem779{
    public int kthGrammar(int N, int K) {
        return traverse(N, K, 0);
    }
    int traverse(int lvl, int K, int curVal) {
        int leaves = (int)Math.pow(2, lvl -2);
        if(lvl == 1)  return curVal;
        else if(K > leaves) return traverse(lvl - 1, K - leaves, curVal == 0 ? 1 : 0);
        else return traverse(lvl - 1, K, curVal == 1 ? 1 : 0);
    }
}
