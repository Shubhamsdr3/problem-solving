package easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    //TODO: FIXME SHUBHAM

    /**
     * a -> e
     * d -> g
     * d -> g
     * @param s
     * @param t
     * @return
     */
    private static boolean isIsomorphic(String s, String t) {
        int index = 0;
        Map<Integer, Integer> map1 =  new HashMap<>();
        for (int i = 0; i < s.length()-1; i++) {
            if (map1.containsKey(index)) {
                map1.put(index, map1.getOrDefault(index, 0) + 1);
            } else {
                map1.put(index, 1);
            }
            if (s.charAt(i) != s.charAt(i+1)) {
                index++;
            }
        }

        Map<Integer, Integer> map2 =  new HashMap<>();
        for (int i = 0; i < t.length()-1; i++) {
            if (map2.containsKey(index)) {
                map2.put(index, map2.getOrDefault(index, 0) + 1);
            } else {
                map2.put(index, 1);
            }
            if (t.charAt(i) != t.charAt(i+1)) {
                index++;
            }
        }
        return false;
    }

    private static boolean isIsomorphic1(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0;i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                if(t.charAt(i) != map.get(s.charAt(i))){
                    return false;
                }
            }else{
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    // The best one.
    private static boolean isIsomorphic2(String s1, String t1) {
        int[] count1 = new int[256];
        int[] count2 = new int[256];

        for (int i =0; i < s1.length(); i++) {
            if (count1[s1.charAt(i)] != count2[t1.charAt(i)]) {
                return false;
            }
            count1[s1.charAt(i)] = i + 1;
            count2[t1.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "add";
        String t = "egg";
        System.out.println(isIsomorphic2(s, t));
    }
}
