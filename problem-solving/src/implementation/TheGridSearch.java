package implementation;

public class TheGridSearch {

    private static String gridSearch(String[] G, String[] P) {
        String res = "";
        int k=0;
        int index = -1;
        for (int i=0; i < G.length; i++) {
            if (k < P.length && isExist(G[i], P[k])) {
                if (i == index + 1) {
                    res = "YES";
                }
                k++;
                index = i;
            }  else {
                res = "NO";
            }
            if ( k == P.length) {
                break;
            }
        }
        return res;
    }

    private static String gridSearch1(String[] G, String[] P) {
        boolean result = false;
        for (int k=0; k < G.length - P.length; k++) {
            int end = P.length;
            int start = 0;
            int count = 0;
            while (end <= G.length) {
                if (isExist(G[k], P[0])) {
                    // if first string matches then check for other string in subsequent elements of G
                    // we already checked for 0
                    for (int i=1; i < P.length; i++) {
                        if (isExist(G[k+i], P[i])) {
                          count++;
                          if (count == P.length -1) {
                              result = true;
                          }
                        }
                    }
                }
                count = 0;
                end++;
                start++;
            }
        }

        if (result) {
            return "YES";
        }
        return "NO";
    }

    private static boolean isExist(String string, String subString) {
        int i = 0;
        int j = subString.length();
        while (i < string.length() && j < string.length()) {
            if (string.substring(i, j).equals(subString)) {
                return true;
            }
            i++;
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] arrG = new String[]
                {
                        "7283455864", "6731158619", "8988242643", "3830589324",
                        "2229505813", "5633845374", "6473530293", "7053106601",
                        "0834282956", "4607924137"
                };
        String[] arrP = new String[]{"9505", "3845", "3530"};

        String[] arrG1 = new String[]
                {
                        "400453592126560", "114213133098692", "474386082879648",
                        "522356951189169", "887109450487496", "252802633388782",
                        "502771484966748", "075975207693780", "511799789562806",
                        "404007454272504", "549043809916080", "962410809534811",
                        "445893523733475", "768705303214174", "650629270887160"
                };
        String[] arrP1 = new String[]{"99", "99"};

        String[] arrG2 = new String[]
                {
                        "123412", "561212", "123634", "781288"
                };

        String[] arrP2 = new String[]{"12", "34"};

        System.out.println(gridSearch1(arrG, arrP));
        System.out.println(gridSearch1(arrG1, arrP1));
        System.out.println(gridSearch1(arrG2, arrP2));

    }
}
