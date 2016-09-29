/**
 * Created by Nikhil on 9/28/16.
 */
public class MyGraph {

    private class Neighbour{
        int vertex_number;
        Neighbour next;

        Neighbour(int vertex_number, Neighbour nbr){
            this.vertex_number = vertex_number;
            next = nbr;
        }
    }

    private class Vertex{
        String vertex_name;
        Neighbour next;

        Vertex( String vertex_name){
            this.vertex_name = vertex_name;
        }


    }
}
