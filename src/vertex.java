import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class vertex<V> {
    private V data;
    private Map<vertex<V>, Double> adjVertices;

    public vertex(V data) {
        this.data = data;
        this.adjVertices = new HashMap<>();
    }

    public V getData() {
        return data;
    }

    public void addAdjVertex(vertex<V> destination, double weight) {
        adjVertices.put(destination, weight);
    }

    public Map<vertex<V>, Double> getAdjVertices() {
        return adjVertices;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        vertex<?> vertex = (vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "Vertex: " + data;
    }
}
