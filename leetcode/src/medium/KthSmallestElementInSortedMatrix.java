package medium;

import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {

    /**
     * Using binary search
     * @param matrix
     * @param k
     * @return
     */
    private static int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length -1][matrix[0].length -1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            int j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count = count + (j + 1);
            }
            if (count < k) low =  mid + 1;
            else  high = mid;;
        }
        return low;
    }

    /**
     * Using Min heap
     * @param matrix
     * @param k
     * @return
     */
    private static int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int j = 0; j <= n -1; j++) {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        for (int i = 0; i < k -1; i++) {
            Tuple t = pq.poll();
            if (t.row == n - 1) {
                continue;
            }
            pq.offer(new Tuple(t.row + 1, t.col, matrix[t.row +1][t.col]));
        }
        return pq.poll().val;
    }

    static class Tuple implements Comparable<Tuple> {

        int row;
        int col;
        int val;
        public Tuple(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
//        System.out.println(kthSmallest1(arr, k));
        System.out.println(kthSmallest(arr, k));
    }
}
