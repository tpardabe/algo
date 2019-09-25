package leetcode;


class Problem1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] array = new int[60];
        int count = 0;
        for(int num: time) {
            if(array[(60 - num %60)%60] > 0) count += array[(60 - num %60)%60];
            array[num %60] +=1;
        }
        return count;
    }
}
