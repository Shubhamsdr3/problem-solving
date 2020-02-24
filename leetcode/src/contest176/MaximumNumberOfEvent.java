package contest176;

public class MaximumNumberOfEvent {

    private static int maxEvents(int[][] events) {
        int days = 1;
        int event = 1;
        for (int i=1; i < events.length; i++) {
            if ((events[i-1][0] != events[i][0]) || events[i-1][1] != events[i][1]) {
                days++;
                if ((days >= events[i][0] && days <= events[i][1])) {
                    event++;
                } else if (days > events[i][0] && events[i][1] < days) {
                    event++;
                }
            }
        }
        return event;
    }

    public static void main(String[] args) {
        int[][] events = new int[][]{
                {1, 2},
                {2, 2},
                {3, 3},
                {3, 4},
                {3, 4}
        };
        int[][] events1 = new int[][]{
                {1, 1},
                {1, 2},
                {2, 2},
        };
//        System.out.println(maxEvents(events));
        System.out.println(maxEvents(events1));
    }
}
