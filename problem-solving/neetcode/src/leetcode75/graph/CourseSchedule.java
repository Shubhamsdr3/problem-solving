package leetcode75.graph;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    /**
     * Using topological sort.
     * @param numCourses
     * @param prerequisites
     * @return
     */
    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // adjacency matrix
        int[] indegree = new int[numCourses];

        // calculate the indegree.
        for (int i = 0; i < prerequisites.length; i++) {
           int ready = prerequisites[i][0];
           int pre = prerequisites[i][1];
           if (matrix[pre][ready] == 0) {
               indegree[ready]++; // duplicate case.
           }
           matrix[pre][ready] = 1;
        }

        // traverse the indegree start the node with indegree 0.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int i = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            // process it's adjacent elements.
            for (int j = 0; j < numCourses; j++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses; // if any of the course is not completed it will return false otherwise true.
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] arr = new int[][] { {1, 0 }, {0, 1} };

        int[][] arr1 = new int[][] { {1, 0 }};
        System.out.println(canFinish(n, arr1));
    }
}
