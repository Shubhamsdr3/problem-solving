package interviewprep;

public class ClockAngleProblem {


    /**
     * Degree(hr) = H * (360/12) + (M * 360)/ (12 * 60)
     * Degree(min) = M * (360/60)
     * @return Math.min(angle, 360 - angle)
     */
    private static int getMinimumAngle(int hour, int min) {
        int h = (hour % 12 + min /60) * 30; // 360/12
        int m = min * 6; // 360/60
        int angle = Math.abs(h - m);
        return Math.min(angle, 360 - angle);
    }

    public static void main(String[] args) {
        int hour = 9;
        int min = 0;
        System.out.println(getMinimumAngle(hour, min));
    }
}
