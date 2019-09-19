package leetcode;

class Problem1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int clockwiseDistance = dfs(distance, start, destination, true);
        int counterClockwiseDistance = dfs(distance, start, destination, false);
        return Math.min(clockwiseDistance, counterClockwiseDistance);
    }
    
    int dfs(int[] distance, int start, int destination, boolean clockwise) {
        int result = 0;
       if(clockwise) {
           while(start != destination) {
               result +=distance[start];
               start = (start +1 ) distance.length;
           }
       } else {
           while(start != destination) {
               start = (start -1 < 0) ? distance.length - 1 : start - 1;
               result +=distance[start];
           }
       }
        return result;
    }
}
