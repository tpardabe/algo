package leetcode;

class Problem717 {
    public boolean isOneBitCharacter(int[] bits) {
        for(int i = 0; i < bits.length; i++) {
            if(i == bits.length -1 && bits[i] == 0) return true;
            if(bits[i] == 1) i++;
        }
        return false;
    }
}
