package leetcode150.linkedlist.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class LRUCache {

    private Map<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>(capacity);
    }

    /**
     * T.C -> O(1)
     * @param key
     * @return
     */
    public int get(int key) {
        return cache.get(key);
    }


    /**
     * T.C => O(1)
     * @param key
     * @param value
     */
    public void put(int key, int value) {

    }

    public static void main(String[] args) {

    }
}
