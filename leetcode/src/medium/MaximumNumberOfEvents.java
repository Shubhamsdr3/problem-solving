package medium;

public class MaximumNumberOfEvents {

    private static int maxEvents(int[][] events) {
        int count = 0;
        for (int i = 0; i < events.length -1; i++) {
            if (canAttendMeeting(events[i], events[i+1])) {
                count++;
            }
        }
        return count;
    }

    private static boolean canAttendMeeting(int[] first, int[] second) {
        return first[1] <= second[0];
    }

    public static void main(String[] args) {
        int[][] events = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4}
        };
        System.out.println(maxEvents(events));
    }
}
