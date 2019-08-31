public class LibraryFine {

    private static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        int fine = -1;
        if (y1 <= y2) {
            if (m1 <= m2) {
                if (d1 <= d2) {
                    fine = 0;
                } else {
                    fine = 15 * (d1 - d2);
                }
            } else {
                fine = 500 * (m1 - m2);
            }
        } else {
            fine = 10000;
        }
        return fine;
    }

    public static void main(String[] args) {
        System.out.println(libraryFine(2, 7, 1014, 1, 1, 1015));
    }
}

