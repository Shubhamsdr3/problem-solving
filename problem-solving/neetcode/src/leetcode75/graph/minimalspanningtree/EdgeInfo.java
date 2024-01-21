package leetcode75.graph.minimalspanningtree;

import java.util.Comparator;

public class EdgeInfo implements Comparator {

    private int vertex1;
    private int vertex2;
    private int weight;

    public EdgeInfo(int vertex1, int vertex2, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    public int getVertex1() {
        return vertex1;
    }

    public void setVertex1(int vertex1) {
        this.vertex1 = vertex1;
    }

    public int getVertex2() {
        return vertex2;
    }

    public void setVertex2(int vertex2) {
        this.vertex2 = vertex2;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return vertex1 + String.valueOf(vertex2);
    }

    @Override
    public int compare(Object o1, Object o2) {
        return ((EdgeInfo) o1).getWeight() - ((EdgeInfo) o2).getWeight();
    }
}
