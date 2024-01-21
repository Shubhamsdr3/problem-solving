package problemsolving.leetcode75.graph.shortestpath;

public class DistanceInfo {

    private int distance;
    private int lastVertex;

    public DistanceInfo(int distance, int lastVertex) {
        this.distance = distance;
        this.lastVertex = lastVertex;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getLastVertex() {
        return lastVertex;
    }

    public void setLastVertex(int lastVertex) {
        this.lastVertex = lastVertex;
    }
}
