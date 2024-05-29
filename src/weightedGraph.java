import java.util.HashMap;
import java.util.Map;

public class weightedGraph<V> {
    private Map<vertex<V>, Map<vertex<V>, Double>> map;

    public weightedGraph() {
        this.map = new HashMap<>();
    }

    public void addVertex(V data) {
        map.putIfAbsent(new vertex<>(data), new HashMap<>());
    }

    public void addEdge(V data1, V data2, double weight) {
        vertex<V> vertex1 = getVertex(data1);
        vertex<V> vertex2 = getVertex(data2);
        map.get(vertex1).put(vertex2, weight);
        map.get(vertex2).put(vertex1, weight);
    }

    public vertex<V> getVertex(V data) {
        for(vertex<V> vertex : map.keySet()) {
            if(vertex.getData().equals(data)) {
                return vertex;
            }
        }
        return null;
    }


    public Map<vertex<V>, Double> getAdjVertices(vertex<V> vertex) {
        return map.get(vertex);
    }

    public Iterable<vertex<V>> getVertices() {
        return map.keySet();
    }
}
