package problemsolving.leetcode75.graph;

public class ShortestPathWithFewestEdge {


    // distance[neighbour] >  distance[vertex]  + wt of edge[vertex, neighbour]
    // if distances are equal we chose the node with fewer edges.
    

    class DistanceTable {

        private int vertexId;
        private int weight;
        private int edges;

        public DistanceTable(int vertexId, int weight, int edges) {
            this.vertexId = vertexId;
            this.weight = weight;
            this.edges = edges;
        }

        public int getVertexId() {
            return vertexId;
        }

        public void setVertexId(int vertexId) {
            this.vertexId = vertexId;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getEdges() {
            return edges;
        }

        public void setEdges(int edges) {
            this.edges = edges;
        }
    }
}
