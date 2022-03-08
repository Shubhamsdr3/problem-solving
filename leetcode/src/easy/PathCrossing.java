package easy;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {

    private static boolean isPathCrossing(String path) {
        char[] arr = path.toCharArray();
        int x = 0;
        int y = 0;
        Set<String> set = new HashSet<>();
        set.add(x + "," + y);
        for (char c: arr) {
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else if (c == 'W') {
                x--;
            }
            if (!set.add(x + "," + y)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "ESSWNN";
        System.out.println(isPathCrossing(str));
    }
}
