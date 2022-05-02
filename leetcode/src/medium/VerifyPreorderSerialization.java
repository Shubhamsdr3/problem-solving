package medium;

public class VerifyPreorderSerialization {

    private static boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        int diff = 1; // for root
        for (String str : arr) {
            if (!str.equals("#")) {
                // if node is nonull, then it produces two children and one parent.
                diff = diff + 2;
            }
            if (--diff < 0) {
                return false;
            }
        }
        return diff == 0;
    }

    public static void main(String[] args) {
        String str = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(isValidSerialization(str));
    }
}
