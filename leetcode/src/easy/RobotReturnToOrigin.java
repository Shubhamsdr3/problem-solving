package easy;

public class RobotReturnToOrigin {

    private static boolean judgeCircle(String moves) {
        char[] arr = moves.toCharArray();
        int x = 0;
        int y = 0;
        for (char c: arr) {
            if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            } else if (c == 'R') {
                x++;
            } else if (c == 'L') {
                x--;
            }
           return x == 0 && y == 0;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "UD";
        System.out.println(judgeCircle(str));
    }
}
