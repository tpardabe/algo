package leetcode;

public class Problem28 {
    public static void main(String[] args) {
        Problem28 problem28 =  new Problem28();
        System.out.println(problem28.strStr("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {
        int lengthA = haystack.length();
        int lengthB = needle.length();
        if( (haystack == null || needle == null) || lengthA < lengthB) return -1;
        else if(lengthA == 0 && lengthB == 0)return 0;
        int index = 0;
        int j = 0;
        int nextIndex = 0;
        for(int i = 0; i < lengthA; i++) {
            if(j == lengthB) return index;
            char currentChar = haystack.charAt(i);
            if(currentChar == needle.charAt(j)){
                if(j++ == 0) index = i;
                if(currentChar == needle.charAt(0)) nextIndex = i;
            }
            else {
                if(j != 0) i = nextIndex-1;
                index =  j = 0;

            }
        }
        return j == lengthB ? index : -1;
    }
}
