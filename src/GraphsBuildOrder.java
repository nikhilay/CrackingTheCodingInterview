import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Nikhil on 10/2/16.
 */
public class GraphsBuildOrder {
    int[] topologicalResult;

    public static void main(String[] args) throws FileNotFoundException {
        GraphsBuildOrder obj = new GraphsBuildOrder();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter graph input file name: ");
        String file = sc.nextLine();
        MyGraph input = new MyGraph(file);
        obj.dfsTopologicalSort(input);

    }

    public void dfsTopologicalSort(MyGraph graphObj) {
        boolean[] visited = new boolean[graphObj.adjacencyList.length];
        topologicalResult = new int[graphObj.adjacencyList.length];
        int position = graphObj.adjacencyList.length - 1;
        System.out.println("Starting at " + graphObj.adjacencyList[0].vertex_name);
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                position = dfsRecursiveTopologicalSort(graphObj, i, visited, topologicalResult, position);
            }
        }
        for (int i = 0; i < topologicalResult.length; i++) {
            System.out.print(graphObj.adjacencyList[topologicalResult[i]].vertex_name + " |");
        }

    }

    private int dfsRecursiveTopologicalSort(MyGraph graphObj, int vertex, boolean[] visited, int[] topologicalResult, int position) {
        visited[vertex] = true;
        System.out.println("Visting " + graphObj.adjacencyList[vertex].vertex_name);
        for (Neighbour nbr = graphObj.adjacencyList[vertex].next; nbr != null; nbr = nbr.next) {
            if (!visited[nbr.vertex_number]) {
                position = dfsRecursiveTopologicalSort(graphObj, nbr.vertex_number, visited, topologicalResult, position);
            }
        }
        topologicalResult[position] = vertex;
        return position - 1;


    }
}
