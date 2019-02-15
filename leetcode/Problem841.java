import java.util.ArrayList;
import java.util.List;

public class Problem841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);
        for(boolean visit: visited){
            if(!visit) return false;
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int source) {
        visited[source] = true;
        for(Integer adjVertexes: rooms.get(source)) {
            if(!visited[adjVertexes])
                dfs(rooms, visited, adjVertexes);
            visited[adjVertexes] = true;
        }
    }
}
