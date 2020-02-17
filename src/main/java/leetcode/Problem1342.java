package leetcode;

class Problem1342 {
    public int numberOfSteps (int num) {
        int count = 0;
        while(num > 0) {
            int and = num & 1;
            if(and == 0) num >>=1; 
            else num--;
            count++;
        }
        return count;
    }
}
