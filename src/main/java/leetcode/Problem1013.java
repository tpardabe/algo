package leetcode;

class Problem1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int avg = 0;
        for(int num: A) avg+=num;
        avg /=3;
        int currentSum = 0;
        boolean[] result = new boolean[3];
        int index = 0;
        for(int num: A) {
            if(index == 3)  {
                break;
            } else if(currentSum + num == avg) {
                result[index++] = true;
                currentSum = 0;
            } else {
                currentSum +=num;
            }
        }
        return result[0] && result[1] && result[2];
    }
}
