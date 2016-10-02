import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nikhil on 9/30/16.
 */
public class GraphsRouteBetweenTwoNodes {

    public static void main(String[] args) throws FileNotFoundException {
        MyGraph graph = new MyGraph("dfs.txt");
        GraphsRouteBetweenTwoNodes obj = new GraphsRouteBetweenTwoNodes();
        obj.checkifRouteExist("A", "C", graph);
    }


    public boolean checkifRouteExist(String vertex1, String vertex2, MyGraph graph) {
        boolean verifyV1 = false;
        boolean verifyV2 = false;
        int vertex1Number = 0;
        int vertex2Number = 0;
        for (int i = 0; i < graph.adjacencyList.length; i++) {
            if (graph.adjacencyList[i].vertex_name.equals(vertex1)) {
                verifyV1 = true;
                vertex1Number = i;
            }

            if (graph.adjacencyList[i].vertex_name.equals(vertex2)) {
                verifyV2 = true;
                vertex2Number = i;
            }
        }

        if (!verifyV1 || !verifyV2) {
            System.out.println("Both or one of the vertices does not exist");
            return false;
        }

        if (vertex1.equals(vertex2)) {
            System.out.println("Both exist and are same vertices");
            return true;
        }
        if (bfs(vertex1Number, graph, vertex2) || bfs(vertex2Number, graph, vertex1)) {
            return true;
        }else {
            System.out.println("Route does not exist");
            return false;
        }


    }

    private boolean bfs(int vertex1, MyGraph graph, String vertex2) {
        boolean[] visited = new boolean[graph.adjacencyList.length];
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[vertex1] = true;
        System.out.println("Starting from " + graph.adjacencyList[vertex1].vertex_name);
        queue.add(vertex1);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (Neighbour nbr = graph.adjacencyList[v].next; nbr != null; nbr = nbr.next) {
                if (!visited[nbr.vertex_number]) {
                    if (graph.adjacencyList[nbr.vertex_number].vertex_name.equals(vertex2)) {
                        System.out.println("Route exist from " + graph.adjacencyList[vertex1].vertex_name + " to " + vertex2);
                        return true;
                    }
                    visited[nbr.vertex_number] = true;
                    queue.add(nbr.vertex_number);
                }
            }
        }
        return false;
    }
}
