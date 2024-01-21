package leetcode75.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class KeysAndRooms {

    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> dfs = new Stack<>();
        dfs.add(0);
        HashSet<Integer> seen = new HashSet<>();
        seen.add(0);
        while (!dfs.isEmpty()) {
            int room = dfs.pop();
            for (int j: rooms.get(room)) {
                if (!seen.contains(j)) {
                    dfs.add(room);
                    seen.add(room);
                    if (rooms.size() == seen.size()) return true;
                }
            }
        }
        return seen.size() == rooms.size();
    }

    public static void main(String[] args) {

    }
}
