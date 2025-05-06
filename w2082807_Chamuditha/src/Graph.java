// Chamuditha Weeramanthri
// 20230393

import java.util.*;
// store the structure of graph
public class Graph {
    // create adjency list
    public List<Edge>[] adjList;
    // total number of nodes of graph
    public int nodes;

    // parameterized constructor
    public Graph(int nodes){
        this.nodes = nodes;
        // create array
        adjList = new ArrayList[nodes];

        for(int i = 0; i< nodes; i++){
            // Assign empty list for all nodes in graph
            adjList[i] = new ArrayList<>();
        }

    }

    public void addEdge(int from , int to , int capacity) {
        Edge e1 = new Edge(from,to,capacity);
        Edge e2 = new Edge(to , from , 0);
        e1.residual = e2;
        e2.residual = e1;
        adjList[from].add(e1);
        adjList[to].add(e2);

    }

    public List<Edge> getEdges(int node){
        return adjList[node];
    }
}