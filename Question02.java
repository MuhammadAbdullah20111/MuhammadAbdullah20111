import java.util.LinkedList;

class Graph {
    private int numVertices;
    private LinkedList<Integer>[] adjLists;

    // Constructor
    public Graph(int vertices) {
        numVertices = vertices;
        adjLists = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    // Add edge
    public void addEdge(int src, int dest) {
        adjLists[src].add(dest);
        adjLists[dest].add(src); // For undirected graph
    }

    // Print the graph
    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer vertex : adjLists[i]) {
                System.out.print(" -> " + vertex);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        graph.printGraph();
    }
}
