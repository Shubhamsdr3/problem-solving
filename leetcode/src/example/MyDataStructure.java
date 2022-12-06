package example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data structure which supports below operation in O(1) time :
 * insert(x): Inserts an item x to the data structure if not already present.
 * remove(x): Removes item x from the data structure if present.
 * search(x): Searches an item x in the data structure.
 * getRandom(): Returns a random element from current set of elements
 *
 * Created at: 05/05/22
*/
public class MyDataStructure {

    private List<Integer> list;

    private Map<Integer, Integer> map;

    MyDataStructure() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public void add(int val) {
        if (map.get(val) != null) return;
        int size = list.size();
        list.add(val);
        map.put(val, size);
    }
}

class HackerRank {
    public void m1(double num) {
        System.out.println("THe number: " + num);
    }
}

class Main extends HackerRank {

    public static void main(String[] args) {


    }
}
