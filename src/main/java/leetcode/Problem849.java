package leetcode;


class Problem849 {
    public int maxDistToClosest(int[] seats) {
        int maxCurrent = 0;
        int maxSoFar = 0;
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 0) {
                maxCurrent += 1;
            } else {
                if(i == maxCurrent) maxCurrent *=2;
                if(maxSoFar < ++maxCurrent) maxSoFar = maxCurrent;
                maxCurrent = 0;
            }
        }
        if(seats[seats.length - 1] == 0 && maxCurrent > maxSoFar/2) return maxCurrent; else return maxSoFar/2;
    }
}
