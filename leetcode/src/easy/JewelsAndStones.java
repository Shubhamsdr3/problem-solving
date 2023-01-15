package easy;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {

    private static int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: stones.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        for (char ch: jewels.toCharArray()) {
            if (map.containsKey(ch)) {
                count = count + map.get(ch);
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        String jewels ="aA";
//        String stones = "aAAbbbb";
        String jewels ="z";
        String stones = "ZZ";
        System.out.println(numJewelsInStones(jewels, stones));
    }
}
