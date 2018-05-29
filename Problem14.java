package leetcode;

public class Problem14 {
    public static void main(String [] args) {
        Problem14 solution = new Problem14();
        String[] array = {};
        System.out.println(solution.longestCommonPrefix(array));
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length ==0) return"";
        StringBuilder builder = new StringBuilder();
        int currentIndex = 0;
        while(currentIndex < strs[0].length()) {
            char current = strs[0].charAt(currentIndex);
            for(int j = 0; j < strs.length; j++) {
                if(currentIndex >= strs[j].length() || current != strs[j].charAt(currentIndex)) return builder.toString();
            }
            builder.append(current);
            currentIndex++;
        }
        return builder.toString();
    }
}
