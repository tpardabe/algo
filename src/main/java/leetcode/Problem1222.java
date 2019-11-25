package leetcode;

class Problem1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int kingX = king[0];
        int kingY = king[1];
        int[] visited = new int[8];
        for(int i = 0; i < visited.length; i++) visited[i] = -1;
        List<List<Integer>> result = new ArrayList();
        for(int i = 0; i < queens.length; i++ ) {
            int x = queens[i][0];
            int y = queens[i][1];
            if(x == kingX && y < kingY) {
                if(visited[1] == -1 || queens[visited[1]][1] < y) visited[1] = i;
            } else if(x > kingX && y < kingY && x - kingX == kingY - y) {
                if(visited[2] == -1 || (queens[visited[2]][0] > x && queens[visited[2]][1] < y)) visited[2] = i;
            } else if(x > kingX && y == kingY) {
                if(visited[3] == -1 || ( queens[visited[3]][0] > x)) visited[3] = i;
            } else if(x > kingX && y > kingY && x- kingX == y - kingY) {
                if(visited[4] == -1 || (queens[visited[4]][0] > x && queens[visited[4]][1] > y)) visited[4] = i;
            } else if(x == kingX && y > kingY) {
                if(visited[5] == -1 || (queens[visited[5]][1] > y)) visited[5] = i;
            } else if(x < kingX && y > kingY && kingX - x == y - kingY) {
                if(visited[6] == -1 || (queens[visited[6]][0] < x && queens[visited[6]][1] > y)) visited[6] = i;
            } else if(x < kingX && y == kingY) {
                if(visited[7] == -1 || queens[visited[7]][0] < x) visited[7] = i;
            } else if(x < kingX && y < kingY && kingX - x == kingY - y) {
                if(visited[0] == -1 || (queens[visited[0]][0] < x  && queens[visited[0]][1] < y)) visited[0] = i;
            }
        }
        for(int i = 0; i < visited.length; i ++) {
            if(visited[i] == -1) continue;
            List<Integer> list = new ArrayList();
            list.add(queens[visited[i]][0]);
            list.add(queens[visited[i]][1]);
            result.add(list);
        }
        return result;
    }
}
