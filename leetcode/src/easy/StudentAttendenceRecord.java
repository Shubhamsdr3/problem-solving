package easy;

public class StudentAttendenceRecord {

    private static boolean checkRecord(String s) {
        if (s.contains("LLL")) {
            return false;
        }
        if (countCharacter(s) > 1) {
            return false;
        }
        return true;
    }

    private static int countCharacter(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == 'A') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "LLL";
        System.out.println(checkRecord(str));
    }
}
