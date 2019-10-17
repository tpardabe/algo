package leetcode;

class Problem125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0;
        int r = s.length() - 1;
        while(l < r) {
            if(!usable(s.charAt(l))) l++;
            else if(!usable(s.charAt(r))) r--;
            else if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
    
    private boolean usable(char s) {
        return (s >= 'a' && s <= 'z') || (s >= '0' && s <= '9');
    }
}
