package leetcode;

public class Problem10 {

    public static void main(String[] args) {
        Problem10 problem10 =  new Problem10();
        System.out.println(problem10.isMatch("aasdfasdfasdfasdfas",
                "aasdf.*asdf.*asdf.*asdf.*s"));
    }

    public boolean isMatch(String s, String p) {
        if(p.length() == 0 && s.length() != 0) return false;
        return recurse(s, p);
    }

    private boolean recurse (String s, String p) {
        char star = '*';
        char dot = '.';
        int i = 0;
        boolean result = true;
        if(s.length() == 0 && p.length() == 0) return result;
        else if(p.length() == 0) return result;
        char patternChar = p.charAt(0);
        boolean withStar = p.length() > 1 && (p.charAt(1) == star) ? true : false;
        if(withStar) {
            int numberOfOccurence = p.length() >1 ? countOccurence(p.substring(2, p.length())) : 0;
            for(; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                if(((currentChar == patternChar || patternChar == dot)&& (i == s.length()- numberOfOccurence) ) || (currentChar != patternChar && patternChar != dot)){
                    break;
                }
            }
            result = recurse(s.substring(i, s.length()), p.substring(2, p.length()));
        } else {
            if(s.length() != 0 && (s.charAt(i) == patternChar || dot == patternChar)) {
                result = recurse(s.substring(1, s.length()), p.substring(1, p.length()));
            } else result = false;
        }
        return result;
    }

    private int countOccurence(String str) {
        int count = 0;
        boolean isStar = false;
        for(int i = str.length()-1 ; i >= 0 ; i--) {
            if(str.charAt(i) == '*') isStar  = true;
            else if(str.charAt(i) != '*' && !isStar) count++;
            else isStar = false;
        }
        return count;
    }
}
