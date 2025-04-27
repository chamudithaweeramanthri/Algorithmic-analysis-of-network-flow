public class Main {
    public static void main(String[] args) {
        try {
            String filePath = "F:\\Algorithmic-analysis-of-network-flow\\ladder_16.txt"; // Make sure this file is in your working directory
            Graph graph = Text.parseFromFile(filePath);
            MaxFlowSolver solver = new MaxFlowSolver();
            //long startTime = System.currentTimeMillis(); // Start time
            int maxFlow = solver.getMaxFlow(graph, 0, graph.nodes - 1);
           // long endTime = System.currentTimeMillis(); // End time
            System.out.println("Maximum Flow: " + maxFlow);
           // System.out.println("Times goes to complete : "+(endTime - startTime)+" Seconds.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
