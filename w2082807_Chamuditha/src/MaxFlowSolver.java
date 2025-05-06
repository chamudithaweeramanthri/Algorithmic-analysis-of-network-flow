// Chamuditha Weeramanthri
// 20230393

import java.util.*;

public class MaxFlowSolver {
    //store the visited nodes as boolean value
    private boolean[] visited;

    //find path using Breadth First Search
    // parent array use to store the path
    public boolean findPath(Graph graph, int s, int t, Edge[] parent) {
        // create queue using linkedlist
        // to store nodes that visited during BFS
        Queue<Integer> queue = new LinkedList<>();

        visited = new boolean[graph.nodes];
        Arrays.fill(parent, null);

        //sourse node add to the queue to start BFS Search
        queue.add(s);
        // Market the Sourse Node as visited
        visited[s] = true;

        // check the queue is empty or not.
        //while loop continue until nodes have in queue.
        while (queue.size() > 0) {
            // stores the node that remove from front of the queue
            int current = queue.poll();

            // for each loop itterate all edges connect with current node
            for (Edge edge : graph.getEdges(current)) {
                // check the node has visited & the capacity
                if (!visited[edge.to] && edge.remainingCapacity() > 0) {
                    parent[edge.to] = edge;
                    visited[edge.to] = true;
                    // Check to node is the Sink node
                    if (edge.to == t){
                        return true;
                    }else{
                        // if not that node added to the queue
                        queue.add(edge.to);
                    }
                }
            }
        }
        return false; // no path found
    }

    public int getMaxFlow(Graph graph, int s, int t) {
        // hold the flow through the graph
        int maxFlow = 0;
        // store edges in augmented paths
        Edge[] parent = new Edge[graph.nodes];

        // while loop run until findPath returns true
        while (findPath(graph, s, t, parent)) {

            int bottleNeck = Integer.MAX_VALUE;

            // Find bottleneck
            for (int node = t; node != s; node = parent[node].from) {
                bottleNeck = Math.min(bottleNeck, parent[node].remainingCapacity());
            }

            // Push flow
            for (int node = t; node != s; node = parent[node].from) {
                parent[node].augment(bottleNeck);
            }

            maxFlow += bottleNeck;
        }

        return maxFlow;
    }
}
