package graph.mst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Using Using Neighbours list
 */
public class BFSAlgorithm {

    private Queue<Node> queue;

    private BFSAlgorithm() {
        this.queue = new LinkedList<>();
    }

    private void bfsTraversal(Node node) {
        queue.add(node);
        node.visited = true;

        while (!queue.isEmpty()) {
            Node element = queue.remove();

            System.out.print(element.data + " t ");

            List<Node> neighbours = element.getNeighbours();

            for (Node n : neighbours) {
                if (n != null && !n.visited) {
                    queue.add(n);
                    n.visited = true;
                }
            }
        }
    }
    static class Node {
        int data;
        boolean visited;
        List<Node> neighbours;

        Node(int data) {
            this.data = data;
            this.neighbours = new ArrayList<>();
        }

        void addNeighbours(Node neighbourNode) {
            this.neighbours.add(neighbourNode);
        }

        List<Node> getNeighbours() {
            return neighbours;
        }
    }

    public static void main(String[] args) {

        Node node40 = new Node(40);
        Node node10 = new Node(10);
        Node node20 = new Node(20);
        Node node30 = new Node(30);
        Node node60 = new Node(60);
        Node node50 = new Node(50);
        Node node70 = new Node(70);

        node40.addNeighbours(node10);
        node40.addNeighbours(node20);
        node10.addNeighbours(node30);
        node20.addNeighbours(node10);
        node20.addNeighbours(node30);
        node20.addNeighbours(node60);
        node20.addNeighbours(node50);
        node30.addNeighbours(node60);
        node60.addNeighbours(node70);
        node50.addNeighbours(node70);

        BFSAlgorithm bfsAlgorithm = new BFSAlgorithm();
        // node40 as start node.
        bfsAlgorithm.bfsTraversal(node40);
    }

}