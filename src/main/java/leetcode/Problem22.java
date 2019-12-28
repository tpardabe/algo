package leetcode;

import java.util.List;
import java.util.Stack;

public class Problem22 {
  public List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet();
        dfs(result, new StringBuilder(), n, 0, 0);
        return new ArrayList(result);
    }
    
    void dfs(Set<String> result, StringBuilder builder, int n, int l, int r) {
        if(l > n) return;
        else if(r == n) result.add(builder.toString());
        else {
            builder.append('(');
            dfs(result, builder, n, l + 1, r);
            builder.setLength(builder.length() - 1);
            if(r +1 <= l) {
                builder.append(')');
                dfs(result, builder, n, l, r + 1);
                builder.setLength(builder.length() - 1);
            }
            
        }
    }
}
