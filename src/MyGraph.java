import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Nikhil on 9/28/16.
 */
class Neighbour {
    int vertex_number;
    Neighbour next;

    Neighbour(int vertex_number, Neighbour nbr) {
        this.vertex_number = vertex_number;
        next = nbr;
    }
}

class Vertex {
    String vertex_name;
    Neighbour next;

    Vertex(String vertex_name, Neighbour nbr) {
        this.vertex_name = vertex_name;
        this.next = nbr;
    }

}

public class MyGraph {
    Vertex[] adjacencyList;

    public MyGraph(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
        String typeOfGraph = sc.next();
        boolean undirected = true;

        if (typeOfGraph.equals("directed")) {
            undirected = false;
        }

        int numberOfVertices = sc.nextInt();
        adjacencyList = new Vertex[numberOfVertices];
        //To read vertices
        for (int i = 0; i < numberOfVertices; i++) {
            Vertex vertexName = new Vertex(sc.next(), null);
            adjacencyList[i] = vertexName;
        }

        //To Read relation between different vertices (Edges)
        while (sc.hasNextLine()) {
            String startAndEndVertex = sc.nextLine().toString();
            if (startAndEndVertex.equals("")) {
                continue;
            }
            System.out.println(startAndEndVertex);
            String[] st = startAndEndVertex.split("\\s+");
            if (st.length == 1) {
                System.out.println("Please mention both the vertices of the edge and try again");
                return;
            }
            int v1 = indexOfVertex(st[0]);
            int v2 = indexOfVertex(st[1]);

            if (v1 == -1 || v2 == -1) {
                System.out.println("Mentioned Vertices does not exist!!");
                return;
            }
            adjacencyList[v1].next = new Neighbour(v2, adjacencyList[v1].next);
            if (undirected) {
                adjacencyList[v2].next = new Neighbour(v1, adjacencyList[v2].next);

            }


        }
    }

    public static void main(String[] args)
            throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter graph input file name: ");
        String file = sc.nextLine();
        MyGraph graph = new MyGraph(file);
        graph.dfs();


    }

    private int indexOfVertex(String input) {
        for (int i = 0; i < adjacencyList.length; i++) {
            if (adjacencyList[i].vertex_name.equals(input)) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        if (adjacencyList.length == 0) {
            System.out.println("Empty List");
            return;
        } else {
            for (int i = 0; i < adjacencyList.length; i++) {
                System.out.print(adjacencyList[i].vertex_name + " ");
                Neighbour iterator = adjacencyList[i].next;
                while (iterator != null) {
                    System.out.print(" ----> " + adjacencyList[iterator.vertex_number].vertex_name);
                    iterator = iterator.next;
                }
                System.out.print("\n");
            }
        }
    }

    public void dfs() {
        boolean[] visited = new boolean[adjacencyList.length];
        System.out.println("Starting at " + adjacencyList[0].vertex_name);
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfsRecursive(i, visited);
            }
        }
    }

    private void dfsRecursive(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println("Visting " + adjacencyList[vertex].vertex_name);
        for (Neighbour nbr = adjacencyList[vertex].next; nbr != null; nbr = nbr.next) {
            if (!visited[nbr.vertex_number]) {
                dfsRecursive(nbr.vertex_number, visited);
            }
        }


    }

}
