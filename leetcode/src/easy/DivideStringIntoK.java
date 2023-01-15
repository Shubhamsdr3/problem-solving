package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideStringIntoK {

    private static String[] divideStringImproved(String str, int k, char fill) {
        if (str.length() == k) {
            return new String[]{str};
        }
        int index = 0;
        int stringLen = str.length();
        StringBuilder sb = new StringBuilder(str);
        String[] strArray = (stringLen % k == 0) ? new String[stringLen / k] : new String[(stringLen / k) + 1];
        // append fill after str
        if (stringLen % k != 0) {
            for (int i = 0; i < k - (stringLen % k); ++i) {
                sb.append(fill);
            }
        }
        // divide into k
        for (int i = 0; i < sb.length(); i += k) {
            strArray[index] = (sb.substring(i, i + k));
            ++index;
        }
        return strArray;
    }

    private static String[] divideString(String s, int k, char fill) {
        int i = 0;
        int j = i + k;
        List<String> list = new ArrayList<>();
        while (i < s.length()) {
            if (j < s.length()) {
                String subString = s.substring(i, j);
                if (subString.length() == k) {
                    list.add(subString);
                } else {
                    StringBuilder sb = new StringBuilder(subString);
                    while (sb.length() <= k) {
                        sb.append(fill);
                    }
                    list.add(sb.toString());
                }
            } else {
                StringBuilder sb = new StringBuilder(s.substring(i));
                while (sb.length() < k) {
                    sb.append(fill);
                }
                list.add(sb.toString());
            }
            i = j;
            j = i + k;
        }
        String[] arr = new String[list.size()];
        for (int idx = 0; idx < arr.length; idx++) {
            arr[idx] = list.get(idx);
        }
        return arr;
    }

    public static void main(String[] args) {
        String str = "abcdefghi";
        int k = 3;
        char fill = 'x';
        System.out.println(Arrays.toString(divideStringImproved(str, k, fill)));
    }
}
