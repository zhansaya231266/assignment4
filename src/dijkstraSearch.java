import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;

public class dijkstraSearch<V> extends search<V> {
    private Map<vertex<V>, Double> distTo;

    public dijkstraSearch(weightedGraph<V> graph, vertex<V> source) {
        distTo = new HashMap<>();
        for(vertex<V> v : graph.getVertices()) {
            distTo.put(v, Double.MAX_VALUE);
        }
        distTo.put(source, 0.0);

        PriorityQueue<vertexDist> pq = new PriorityQueue<>(Comparator.comparingDouble(vertexDist::getDistance));
        pq.add(new vertexDist(source, 0.0));

        while(!pq.isEmpty()) {
            vertexDist vertDist = pq.poll();
            vertex<V> v = vertDist.getVertex();

            for(Map.Entry<vertex<V>, Double> entry : graph.getAdjVertices(v).entrySet()) {
                relax(entry.getKey(), entry.getValue(), pq);
            }
        }
    }

    private void relax(vertex<V> w, Double weight, PriorityQueue<vertexDist> pq) {
        vertex<V> v = edgeTo.get(w);
        if(v != null && distTo.get(w) > distTo.get(v) + weight) {
            distTo.put(w, distTo.get(v) + weight);
            edgeTo.put(w, v);
            pq.add(new vertexDist(w, distTo.get(w)));
        }
    }

    public double distTo(vertex<V> v) {
        return distTo.getOrDefault(v, Double.MAX_VALUE);
    }

    private class vertexDist {
        private vertex<V> vertex;
        private double distance;

        public vertexDist(vertex<V> vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public vertex<V> getVertex() {
            return vertex;
        }

        public double getDistance() {
            return distance;
        }
    }
}
