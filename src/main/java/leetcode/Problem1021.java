package leetcode;
class Problem1021 {
    public String removeOuterParentheses(String S) {
       if(S == null || S.isEmpty()) return S;
        Stack<Character> stack = new Stack();
        StringBuilder builder = new StringBuilder();
        int openCount = 0;
        int closeCount = 0;
        int startIndex = -1;
        for(int i = 0; i < S.length(); i++) {
            char current = S.charAt(i);
            if(stack.isEmpty()) startIndex = i;
            stack.push(current);
            if(current == '(') openCount++;
            else closeCount++;
            int count = 0;
            while(!stack.isEmpty() && current == ')' && openCount == closeCount) {
                stack.pop();
                count++;
                openCount = 0;
                closeCount = 0;
            }
            int size = count;
            if(stack.isEmpty() && size > 2) {
                String s = builder.toString();
                builder.append(S.substring(startIndex+1, i));
            }
        }
        return builder.toString();
    }
}
