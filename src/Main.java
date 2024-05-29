public class Main {
    public static void main(String[] args) {
        weightedGraph<String> graph = new weightedGraph<>();
        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");

        graph.addEdge("a", "b", 6.0);
        graph.addEdge("b", "c", 3.0);
        graph.addEdge("a", "c", 5.0);
    }
}
