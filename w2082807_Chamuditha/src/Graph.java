import java.util.*;
// store the structure of graph
public class Graph {
    // create adjency list
    public List<Edge>[] adjList;
    // total number of nodes of graph
    public int n;

    //parameterized constructor
    public Graph(int n){
        this.n = n;
        // create array
        adjList = new ArrayList[n];
        for(int i=0; i<n; i++){
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from , int to , int capacity){
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
