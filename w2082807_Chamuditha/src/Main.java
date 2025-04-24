public class Main {
    public static void main(String[] args) {
        try {
            String filePath = "network.txt"; // Make sure this file is in your working directory
            Graph graph = Parser.parseFromFile(filePath);
            MaxFlowSolver solver = new MaxFlowSolver();
            int maxFlow = solver.getMaxFlow(graph, 0, graph.n - 1);
            System.out.println("Maximum Flow: " + maxFlow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
