package leetcode;


class Problem131 {
    public List<List<String>> partition(String s) {
        Set<List<String>> list = new HashSet();
        dfs(list, s, new ArrayList());
        return new ArrayList(list);
    }
    
    void dfs(Set<List<String>> result, String s, List<String> list) {
        if(s.isEmpty()) {
            List<String> ss = new ArrayList(list);
            result.add(ss);
            return;
        } else if(isPalindrome(s)) {
            list.add(s);
            List<String> ss = new ArrayList(list);
            result.add(ss);
            list.remove(list.size() - 1);
        }
        for(int i = 1; i < s.length(); i++ ) {
            String s1 = s.substring(0, i);
            boolean v1 = isPalindrome(s1);
            if(v1 && !s1.isEmpty()) {
                list.add(s1);
                dfs(result, s.substring(i), list);
                list.remove(list.size() -1);
            }
        }
    }
    
    boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() -1;
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }


}
