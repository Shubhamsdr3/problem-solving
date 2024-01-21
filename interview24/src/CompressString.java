public class CompressString {

    private static String compressString(String inputString) {
        StringBuilder res = new StringBuilder();
        String str = inputString.toLowerCase();
        int count = 0;
        for (int i=0; i < str.length(); i++) {
            count++;
            if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                res.append(inputString.charAt(i));
                res.append(count);
                count = 0;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String inputString =  "aabcccccdddd";
        System.out.println(compressString(inputString));
    }
}
