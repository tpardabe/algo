package leetcode;

public class Problem58 {

    public static void main(String[] args ){
        Problem58 solution = new Problem58();
        solution.solve();
    }

    public void solve(){
        System.out.println(lengthOfLastWord(""));
    }

    public int lengthOfLastWord(String s) {
        int length = 0;
        if(s == null)  return length;
        for(int i = s.length()-1; i >=0; i--) {
            if(s.charAt(i) == ' ' && length == 0)continue;
            if(s.charAt(i) == ' ') break;
            length++;
        }
        return length;
    }
}
