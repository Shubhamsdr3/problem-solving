package easychallenge;

public class MalicksChallange {

    private static String sortString(String str) {
        int index = 1;
        for (int i= 0; i < str.length()-1; i++) {
            if (str.charAt(i) > str.charAt(i+1)) {
                String temp = sort(str, i, index);
                if (temp.compareTo(str) < 0) {
                    return temp;
                }
            }
            index++;
        }
        return "";
    }

    private static String sort(String str, int start, int end) {
        char[] arr = str.toCharArray();
        char temp = arr[start];
        for (int i=start+1; i <= end; i++) {
            arr[start] = arr[i];
        }
        arr[end] = temp;
        StringBuilder sb = new StringBuilder();
        for (char c: arr) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "AMJJB";
        System.out.println(sortString(str));
    }
}
