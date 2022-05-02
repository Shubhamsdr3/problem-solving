package medium;

/**
 * Created at: 25/04/22
 */
public class ReorganizeString {

    /**
     * MY way: failed at "baaba"
     * @param s
     * @return
     */
    private static String reorganizeString(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && arr[i] == arr[i + 1]) {
                int start = i + 2;
                while (start < arr.length && arr[i] == arr[start]) {
                    start++;
                }
                swap(arr, i +1, start);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && arr[i] == arr[i+1]) {
                return "";
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    private static void swap(char[] arr, int i, int start) {
        if (start < arr.length) {
            char temp = arr[i];
            arr[i] = arr[start];
            arr[start] = temp;
        }
    }

    /**
     * Improved
     * TC: O(n): fill count[] + find the letter + write results into char array
     * SC: O(N + 26): result + count
     * @param s
     * @return
     */

    private static String reorganizeStringImproved(String s) {
        int[] count = new int[26];
        // get the frequency of every character.
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int max = 0;
        int letter = 0;
        // get the letter with max frequency
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                letter = i;
            }
        }

        // not possible
        if (max > (s.length() + 1) / 2) {
            return "";
        }

        char[] res = new char[s.length()];
        int index = 0;
        // add char at even index
        while (count[letter] > 0) {
            res[index] = (char) (letter + 'a');
            index = index + 2;
            count[letter]--;
        }

        // add char at odd index
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                if (index >= res.length) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index = index +2;
                count[i] --;
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String str = "baaba"; // ababa
        System.out.println(reorganizeStringImproved(str));
    }
}
