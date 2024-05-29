import java.util.LinkedList;
import java.util.Queue;

public class breadthFirstSearch<V> extends search<V> {

    public breadthFirstSearch(weightedGraph<V> graph, vertex<V> source) {
        bfs(graph, source);
    }

    private void bfs(weightedGraph<V> graph, vertex<V> source) {
        Queue<vertex<V>> queue = new LinkedList<>();
        queue.add(source);
        visited.put(source, true);

        while(!queue.isEmpty()) {
            vertex<V> v = queue.poll();
            for(vertex<V> w : graph.getAdjVertices(v).keySet()) {
                if(!visited.getOrDefault(w, false)) {
                    visited.put(w, true);
                    edgeTo.put(w, v);
                    queue.add(w);
                }
            }
        }
    }
}
