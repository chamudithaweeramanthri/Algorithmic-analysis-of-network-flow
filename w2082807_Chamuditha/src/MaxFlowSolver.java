//public class MaxFlowSolver {
//    // store the visited nodes as (true/false)
//    // to avoid visiting the same node again
//    private boolean[] visited;
//
//    public int dfs(Graph graph, int node, int t, int flow) {
//        if (node == t) return flow;
//        visited[node] = true;
//
//        for (Edge edge : graph.getEdges(node)) {
//            if (!visited[edge.to] && edge.remainingCapacity() > 0) {
//                int bottleNeck = dfs(graph, edge.to, t, Math.min(flow, edge.remainingCapacity()));
//                if (bottleNeck > 0) {
//                    edge.augment(bottleNeck);
//                    return bottleNeck;
//                }
//            }
//        }
//        return 0;
//    }
//
//    public int getMaxFlow(Graph graph, int s, int t) {
//        int maxFlow = 0;
//        while (true) {
//            visited = new boolean[graph.nodes];
//            int flow = dfs(graph, s, t, Integer.MAX_VALUE);
//            if (flow == 0) break;
//           // System.out.println("Augmented path with flow: " + flow);
//            maxFlow += flow;
//        }
//        return maxFlow;
//    }
//}


//import java.util.*;
//
//public class MaxFlowSolver {
//    //store the visited nodes
//    private boolean[] visited;
//
//    //use breadth-fisrt search to find the path
//    public int bfs(Graph graph, int s, int t, Map<Integer, Edge> parent) {
//        Queue<Integer> queue = new LinkedList<>();
//        visited = new boolean[graph.nodes];
//        queue.add(s);
//        visited[s] = true;
//
//        while (!queue.isEmpty()) {
//            int current = queue.poll();
//
//            for (Edge edge : graph.getEdges(current)) {
//                if (!visited[edge.to] && edge.remainingCapacity() > 0) {
//                    parent.put(edge.to, edge);
//                    visited[edge.to] = true;
//                    if (edge.to == t) {
//                        return 1; // Found path
//                    }
//                    queue.add(edge.to);
//                }
//            }
//        }
//        return 0; // No path found
//    }
//
//    public int getMaxFlow(Graph graph, int s, int t) {
//        int maxFlow = 0;
//        Map<Integer, Edge> parent = new HashMap<>();
//
//        while (true) {
//            parent.clear();
//            if (bfs(graph, s, t, parent) == 0) break;
//
//            int bottleNeck = Integer.MAX_VALUE;
//
//            int current = t;
//            while (current != s) {
//                Edge edge = parent.get(current);
//                bottleNeck = Math.min(bottleNeck, edge.remainingCapacity());
//                current = edge.from;
//            }
//
//            current = t;
//            while (current != s) {
//                Edge edge = parent.get(current);
//                edge.augment(bottleNeck);
//                current = edge.from;
//            }
//            maxFlow += bottleNeck;
//        }
//
//        return maxFlow;
//    }
//}




//import java.util.*;
//
//public class MaxFlowSolver {
//    // store the visited nodes
//    private boolean[] visited;
//
//    // use breadth-first search to find a path from source to sink
//    public int bfs(Graph graph, int s, int t, Edge[] parent) {
//        Queue<Integer> queue = new LinkedList<>();
//        visited = new boolean[graph.nodes];
//        queue.add(s);
//        visited[s] = true;
//
//        while (queue.size()>0) {
//            int current = queue.poll();
//
//            for (Edge edge : graph.getEdges(current)) {
//                if (!visited[edge.to] && edge.remainingCapacity() > 0) {
//                    parent[edge.to] = edge; // instead of put, assign directly
//                    visited[edge.to] = true;
//                    if (edge.to == t) {
//                        return 1; // Found path
//                    }
//                    queue.add(edge.to);
//                }
//            }
//        }
//        return 0; // No path found
//    }
//
//    public int getMaxFlow(Graph graph, int s, int t) {
//        int maxFlow = 0;
//        Edge[] parent = new Edge[graph.nodes]; // instead of Map, using array
//
//        while (true) {
//            Arrays.fill(parent, null); // clear previous parent data
//            if (bfs(graph, s, t, parent) == 0) break;
//
//            int bottleNeck = Integer.MAX_VALUE;
//
//            int current = t;
//            // find minimum available capacity (bottleneck)
//            while (current != s) {
//                Edge edge = parent[current];
//                bottleNeck = Math.min(bottleNeck, edge.remainingCapacity());
//                current = edge.from;
//            }
//
//            current = t;
//            // augment the flow along the path
//            while (current != s) {
//                Edge edge = parent[current];
//                edge.augment(bottleNeck);
//                current = edge.from;
//            }
//            maxFlow += bottleNeck;
//        }
//
//        return maxFlow;
//    }
//}

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
            //System.out.println("Augmented a path with flow: " + bottleNeck);
        }

        return maxFlow;
    }
}
