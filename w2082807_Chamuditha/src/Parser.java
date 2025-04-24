import java.io.*;

public class Parser {
    public static Graph parseFromFile(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        int n = Integer.parseInt(br.readLine().trim());
        Graph graph = new Graph(n);

        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.trim().split("\\s+");
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            int capacity = Integer.parseInt(parts[2]);
            graph.addEdge(from, to, capacity);
        }

        br.close();
        return graph;
    }
}
