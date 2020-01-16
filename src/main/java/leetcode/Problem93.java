package leetcode;

class Problem93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList();
        dfs(new LinkedList(), list, s, 4);
        return list;
    }
    
    void dfs(LinkedList<String> cur, List<String> list, String s, int n) {
        if(n == 0) {
            StringBuilder builder = new StringBuilder();
            for(String ss: cur) builder.append(ss);
            list.add(builder.toString());
            return;
        } else if(n * 3 < s.length()) {
          return;
        } else {
            for(int i = 1; i <= 3; i++) {
                if(i > s.length()) return;
                else if(n == 1 && i < s.length()) continue;
                String dot = "";
                if(n > 1)  dot += ".";
                String number = s.substring(0, i);
                if(notValid(number)) continue;
                String str = number + dot;
                cur.add(str);
                dfs(cur, list, s.substring(i), n - 1);
                cur.removeLast();
            }
        }
    }
    
    boolean notValid(String number) {
        if(Integer.valueOf(number) > 255) return true;
        else if(number.length() > 1  && number.charAt(0) == '0') return true;
        return false;
    }
}
