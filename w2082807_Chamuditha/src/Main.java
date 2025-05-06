// Chamuditha Weeramanthri
// 20230393

public class Main {
    public static void main(String[] args) {
        try {
            String filePath = "w2082807_Chamuditha/Benchmark/bridge_1.txt";
            Graph graph = Text.parseFromFile(filePath);
            MaxFlowSolver solver = new MaxFlowSolver();
            // Algorithm Start time
            long startTime = System.nanoTime();
            int maxFlow = solver.getMaxFlow(graph, 0, graph.nodes - 1);
            // Algorithm End time
            long endTime = System.nanoTime();
            // display the maximum flow.
            System.out.println("Maximum Flow: " + maxFlow);
            // calculate the total time and display.
            System.out.println("Total Time Taken : " +((endTime - startTime) / 1e6)+" ms.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
