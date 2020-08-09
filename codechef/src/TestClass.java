import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestClass {

    private static String CountOccurrences(String S){
        // Your code goes here
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(CountOccurrences("occurrences"));
    }

}
