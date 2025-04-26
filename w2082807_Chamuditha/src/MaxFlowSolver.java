public class MaxFlowSolver {
    private boolean[] visited;

    public int dfs(Graph graph, int node, int t, int flow) {
        if (node == t) return flow;
        visited[node] = true;

        for (Edge edge : graph.getEdges(node)) {
            if (!visited[edge.to] && edge.remainingCapacity() > 0) {
                int bottleNeck = dfs(graph, edge.to, t, Math.min(flow, edge.remainingCapacity()));
                if (bottleNeck > 0) {
                    edge.augment(bottleNeck);
                    return bottleNeck;
                }
            }
        }
        return 0;
    }

    public int getMaxFlow(Graph graph, int s, int t) {
        int maxFlow = 0;
        while (true) {
            visited = new boolean[graph.nodes];
            int flow = dfs(graph, s, t, Integer.MAX_VALUE);
            if (flow == 0) break;
           // System.out.println("Augmented path with flow: " + flow);
            maxFlow += flow;
        }
        return maxFlow;
    }
}