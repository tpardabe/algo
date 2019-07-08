package leetcode;

import java.util.Stack;

public class Problem71 {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int currentIndex = 0;
        for(int i = 0; i < path.length(); i++) {
            char cur = path.charAt(i);
            if(i > 0 && ( i +1 == path.length() -1
                    || (i < path.length()-2 && path.charAt(i+2) == '/')) && cur == '.' && path.charAt(i + 1) == '.' && path.charAt(i-1) == '/'
            ) {
                if(!stack.isEmpty()) stack.pop();
                currentIndex = i + 2;
                i++;
            } else if(cur == '.' && i > 0 && path.charAt(i-1) == '/'
                    && ( i == path.length() -1
                    || (i < path.length()-1 && path.charAt(i+1) == '/')))
                currentIndex = i +1;
            else if(cur == '/') {
                if(i > 0 && path.charAt(i-1) != '/' && currentIndex != i) stack.push(path.substring(currentIndex, i));
                currentIndex = i;
            } else if(i == path.length() -1){
                stack.push(path.substring(currentIndex, i + 1));
            }
        }
        if(stack.isEmpty()) stack.push("/");
        StringBuilder builder = new StringBuilder();
        build(stack, builder);
        return builder.toString();
    }

    private void build(Stack<String> stack, StringBuilder builder) {
        if(stack.isEmpty()) return;
        String res = stack.pop();
        build(stack, builder);
        builder.append(res);
    }

    public static void main(String[] args) {
        Problem71 problem71 = new Problem71();
        System.out.println(problem71.simplifyPath("/../"));
    }
}
