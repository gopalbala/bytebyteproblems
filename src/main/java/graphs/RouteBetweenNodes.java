package graphs;

import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gbalasubramanian on 22/11/17.
 */
public class RouteBetweenNodes {
    public static void main(String[] args) {

    }

}

class Graph{
    GraphNode root;

    static boolean search(GraphNode root, GraphNode start,GraphNode end){
        if (start == end)
            return true;
        LinkedList<GraphNode> graphNodes = new LinkedList<>();
        graphNodes.add(root);
        GraphNode u;
        while (!graphNodes.isEmpty()){
           u = graphNodes.removeFirst();
           if (u!=null){
               for (GraphNode neighbor: u.neighbors){
                   if (!neighbor.visited){
                       if (neighbor == end)
                           return true;
                       else {
                           graphNodes.add(neighbor);
                       }
                   }
                   neighbor.visited =true;
               }
           }
        }
        return false;
    }
}

enum State { Unvisited, Visited, Visiting; }

class GraphNode{
    int val;
    boolean visited;
    List<GraphNode> neighbors;
}
