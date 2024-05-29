public class edge<V> {
    private vertex<V> source;
    private vertex<V> dest;
    private Double weight;

    public edge(vertex<V> source, vertex<V> dest, Double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public vertex<V> getSource() {
        return source;
    }

    public vertex<V> getDest() {
        return dest;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge: " + source + ", " + dest + ", " + weight;
    }
}
