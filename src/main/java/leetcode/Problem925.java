package leetcode;

class Problem925 {
    public boolean isLongPressedName(String name, String typed) {
        int nameLength = name.length();
        int typedLength = typed.length();
        if(nameLength > typedLength) return false;
        int l = 0;
        int k = 0;
        while(k < typedLength) {
            if(l < nameLength && name.charAt(l) == typed.charAt(k)) {
                l++;
                k++;
            } else k++;
        }
        return l == nameLength ?  true : false;
    }
}
