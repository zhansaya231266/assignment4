import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class search<V> {
    protected Map<vertex<V>, Boolean> visited;
    protected Map<vertex<V>, vertex<V>> edgeTo;

    public search() {
        this.visited = new HashMap<>();
        this.edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(vertex<V> v) {
        return visited.getOrDefault(v, false);
    }

    public Iterable<vertex<V>> pathTo(vertex<V> v) {
        if(!hasPathTo(v)) return null;
        LinkedList<vertex<V>> path = new LinkedList<>();
        for(vertex<V> x = v; x != null; x = edgeTo.get(x)) {
            path.add(x);
        }
        return path;
    }
}
