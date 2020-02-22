package leetcode;

class Problem476 {
    public int findComplement(int num) {
        int num1 = num;
        int index = 0;
        while(num1 > 0) {
            num1 >>= 1;
            index++;
        }
        for(int i = 0; i < index; i++) {
            int cur = num & (1<< i);
            num ^= (1 << i);
        }
        return num;
    }
}
