package recursion;

import java.util.*;

public class PasswordChecker {

    private static String passwordCracker(List<String> passwords, String loginAttempt) {
        HashMap<String, Integer> passwordCount = new LinkedHashMap<>();
        for (int i =0; i < passwords.size(); i++) {
            if (passwordCount.containsKey(passwords.get(i))) {
                int count = passwordCount.get(passwords.get(i));
                passwordCount.put(passwords.get(i), ++count);
            } else {
                passwordCount.put(passwords.get(i), 1);
            }
        }

        int i =0;
        int j = i+1;
//        List<String> stringList = new LinkedList<>();
        int size = 0;
        StringBuilder builder = new StringBuilder();
        while (i < loginAttempt.length()) {
            if (passwordCount.containsKey(loginAttempt.substring(i, j))) {
                size++;
                builder.append(loginAttempt, i, j);
                builder.append(" ");
                i = j;
            }
            j++;
            if (j == loginAttempt.length()) {
                break;
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("because");
//        list.add("can");
//        list.add("do");
//        list.add("must");
//        list.add("we");
//        list.add("what");
//        String loginAttempt = "wedowhatwemustbecausewecan";

        List<String> list1 = new ArrayList<>();
        list1.add("hello");
        list1.add("planet");
        String loginAttempt1 = "helloworld";

        List<String> list2 = new ArrayList<>();
        list2.add("ab");
        list2.add("abcd");
        list2.add("cd");
        String loginAttempt2 = "abcd";
        System.out.println(passwordCracker(list2, loginAttempt2));

    }
}
