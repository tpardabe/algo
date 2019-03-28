package codeforces;
import java.io.PrintWriter;
import java.util.Scanner;

public class Problem1020B {
    static int[] graph;
    public static void main(String[] args) {
        try {

            //File file  =  new File("/home/talgat/Desktop/personal/algo/src/main/resources/input.txt");
            Scanner scanner = new Scanner(System.in);
            PrintWriter os =  new PrintWriter(System.out);
            int numberOfVertexes = scanner.nextInt();
            graph = new int[numberOfVertexes];
            int[] result = new int[numberOfVertexes];
            for(int i =0; i < numberOfVertexes; i++) {
                graph[i] = scanner.nextInt();
            }
            for(int i =0; i < numberOfVertexes; ++i) {
                boolean[] visited = new boolean[numberOfVertexes];
                visited[i] = true;
                result[i] = dfs(graph, visited, i);
                //System.out.println("i: " + result[i]);
                os.print(result[i] +" ");
            }
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    static int dfs(int[] graph, boolean[] visited, int source) {
        int adjacency = graph[source];
        int adjIndex = adjacency - 1;
        if(visited[adjIndex]) return adjacency;
        visited[adjIndex] =  true;
        return dfs(graph, visited, adjIndex);
    }

}
