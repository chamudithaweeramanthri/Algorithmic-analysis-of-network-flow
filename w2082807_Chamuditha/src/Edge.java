public class Edge {
    // add the required variables for the graph.
    int from;
    int to;
    int capacity;
    int flow;

    // connect edge with reverse edge
    Edge residual;

    //parameterized constructor
    public Edge(int from ,int to  ,int capacity){
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;

    }

    //calculate the remining space from full capacity in edge
    public int remainingCapacity(){
        return capacity - flow;
    }

    public void augment(int bottleNeck){
        flow += bottleNeck;
        residual.flow -= bottleNeck;
    }

    @Override
    public String toString() {
        return String.format("Edge %d -> %d | flow = %d / %d",from,to,flow,capacity);
    }

}
