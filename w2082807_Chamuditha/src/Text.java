// Chamuditha Weeramanthri
// 20230393

import java.io.*;

public class Text {
    public static Graph parseFromFile(String filePath) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(filePath));

        // read first line of the txt file
        int n = Integer.parseInt(br.readLine().trim());
        // create graph object
        Graph graph = new Graph(n);

        String line;
        //while loop for read all lines in txt file
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            // Seperate the numbers in file by spaces
            String[] parts = line.trim().split("\\s+");
            // assign that numbers to the indexes
            int from = Integer.parseInt(parts[0]);
            int to = Integer.parseInt(parts[1]);
            int capacity = Integer.parseInt(parts[2]);
            graph.addEdge(from, to, capacity);
        }

        br.close();
        return graph;
    }
}
