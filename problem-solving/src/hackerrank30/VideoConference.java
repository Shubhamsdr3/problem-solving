package hackerrank30;

import java.util.*;

public class VideoConference {

    private static List<String> solve(List<String> names) {
        HashMap<String, String> persons = new LinkedHashMap<>();
        persons.put(names.get(0), names.get(0).substring(0, 1));
        for (int i=1; i < names.size(); i++) {
            if (persons.get(names.get(i)) == null ) {
                String shortestPrefix =  getShortestPrefix(persons, names.get(i-1), names.get(i));
                persons.put(names.get(i), shortestPrefix);
            } else {
                String val = names.get(i);
                persons.put(val + 2, val + " " + 2);
            }
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> val: persons.entrySet()) {
            list.add(val.getValue());
        }
        return list;
    }

    private static String getShortestPrefix(HashMap<String, String> persons, String str1, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= str1.length(); i++) {
            if (i < str1.length() && str1.charAt(i) == str2.charAt(i) && !persons.containsValue(str2.charAt(i) +"")) {
                stringBuilder.append(str2.charAt(i));
            } else {
                stringBuilder.append(str2.charAt(i));
                if (persons.containsValue(str2.charAt(i) +"")) {
                    stringBuilder.append(str2.charAt(i+1));
                }
                break;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] inputArray = new String[]{"alvin", "alice", "alvin"};
        String[] inputArray1 = new String[]{"mary", "stacy", "sam", "samuel", "sam", "miguel"};
        List<String> list = new ArrayList<>(Arrays.asList(inputArray1));
        System.out.println(solve(list));
    }

}
