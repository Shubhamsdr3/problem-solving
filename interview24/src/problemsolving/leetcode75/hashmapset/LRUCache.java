package problemsolving.leetcode75.hashmapset;

import java.util.LinkedHashMap;
import java.util.Map;


public class LRUCache {

    class Node {
        Node prev;
        Node next;

        int key;

        int value;

        Node(int _key, int _value) {
            this.key = _key;
            this.value = _value;
        }
    }

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    // key, node
    private Map<Integer, Node> cache;

    //Doubly linked list

    private static int CAPACITY = 5;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>(CAPACITY);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * T.C -> O(1)
     * @param key
     * @return
     */
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            // remove the node from least recently used to last used.
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    private void insert(Node node) {
        cache.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    private void remove(Node node) {
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * T.C => O(1)
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        if (cache.size() >= CAPACITY) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    public static void main(String[] args) {

    }
}
