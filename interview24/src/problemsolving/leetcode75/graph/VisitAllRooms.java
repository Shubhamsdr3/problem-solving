package problemsolving.leetcode75.graph;

import java.util.*;

public class VisitAllRooms {

    /**
     * DFS
     * @param rooms
     * @return
     */
    private static boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            for (int j: rooms.get(current)) {
                if (!visited.contains(j)) {
                    stack.push(j);
                    visited.add(j);
                    if (rooms.size() == visited.size()) return true;
                }
            }
        }
        return rooms.size() == visited.size();
    }

    /**
     * BFS
     * @param rooms
     * @return
     */
    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> toVisit = new LinkedList<>();
        toVisit.offer(0);
        while (!toVisit.isEmpty()) {
            int current = toVisit.poll();
            visited.add(current);
            for (int k : rooms.get(current)) {
                if (visited.get(k) == visited.get(visited.size() - 1)) {
                    toVisit.offer(k);
                }
            }
        }
        return visited.size() == rooms.size();
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        input.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list1.add(3);
        list1.add(0);
        list1.add(1);
        input.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        input.add(list3);
        List<Integer> list4 = new ArrayList<>();
        list3.add(0);
        input.add(list4);

        System.out.println(canVisitAllRooms2(input));
    }
}
