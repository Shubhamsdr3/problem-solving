package medium;

import java.util.*;

public class WordBreak {

    /**
     * Using BFS
     * T.C -> O(n^3)
     * S.C. -> O(n)
     * @param s
     * @param wordDict
     * @return
     */
    private static boolean wordBreakUsingBFS(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict); // to remove the duplicacy.
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[wordDict.size()];
        queue.add(0); // first index is visited.
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start]) { // this index has been visited so continue.
                continue;
            }
            // otherwise get the substring and check if wordDictSet contain this substring.
            for (int end = start + 1; end <= s.length(); end++) {
                String subString = s.substring(start, end);
                if (wordDictSet.contains(subString)) {
                    queue.add(end);
                    if (end == s.length()) {
                        return true;
                    }
                }
            }
            visited[start] = true;
        }
        return false;
    }

    /**
     * Backtracking and recursion.
     * T.C -> O(2^n)
     * S.C -> O(n)
     * @param s
     * @param wordDict
     * @return
     */
    private static boolean wordBreak(String s, List<String> wordDict) {
        return backtrack(s, new HashSet<>(wordDict), 0);
    }

    private static boolean backtrack(String s, HashSet<String> wordDict, int start) {
        if (start == s.length()) return true;
        for (int end = start; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && backtrack(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(wordBreak(str, wordDict));

        String str1 = "catsandog";
        List<String> wordDict1 = new ArrayList<>();
        wordDict1.add("cats");
        wordDict1.add("dog");
        wordDict1.add("sand");
        wordDict1.add("and");
        wordDict1.add("cat");
        System.out.println(wordBreakUsingBFS(str1, wordDict1));

        String str2 ="cars";
        List<String> wordDict2 = new ArrayList<>();
        wordDict2.add("car");
        wordDict2.add("ca");
        wordDict2.add("rs");
        System.out.println(wordBreak(str2, wordDict2));

        String str3 = "cbca";
        List<String> wordDict3 = new ArrayList<>();
        wordDict3.add("bc");
        wordDict3.add("ca");
//        System.out.println(wordBreakUsingBFS(str3, wordDict3));
    }
}
