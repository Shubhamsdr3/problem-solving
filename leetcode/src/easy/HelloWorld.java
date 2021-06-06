package easy;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {



    private static String getTheSmalledSubString(String str, char[] chars) {
        int i = 0;
        String ans = "";
        int j = chars.length;
        while(i < str.length() && j < str.length()) {
            String subString = str.substring(i, j);
            for(int index = 0; index < chars.length; index++) {
                if(!subString.contains(chars[index] +"")) {
                    j++;
                    break;
                }
                if(index == chars.length -1 ) {
                    if(subString.length() < ans.length()) {
                        ans = subString;
                    }
                    j = j + chars.length;
                    i++;
                }
            }
        }
        return ans;
    }

    /**  1487799425 -> 14 - 6 == 8
     *  1487800378 -> 8 + 10  == 18
     *
     *  1487801478 -> 18 - 21 == -3
     *  1487801478 -> -3 + 20 == 17
     *  1487901013 -> 18 -1 == 17
     *  1487901211 -> 17 + 7 = 24
     *  1487901211 -> 24 - 7 = 17
     *
     *     0 -> timestamp
     *     1 -> number of people
     *     2 -> exit/enter
     * [ [1487799425, 14, 1],
     *
     *                  [1487799425, 4,  0],
     *
     *                  [1487799425, 2,  0],
     *
     *                  [1487800378, 10, 1],
     *
     *                  [1487801478, 21, 0],
     *                  [1487801478, 20, 1],
     *
     *                  [1487901013, 1,  0],
     *
     *                  [1487901211, 7,  1],
     *                  [1487901211, 7,  0]
     *                  ]
     */

    private static long getTheNumberOfPeople(int[][] arr) {
        int maxNumberOfPeople = 0;
        long currentTimeStamp = 0;
        for (int i = 0; i < arr.length; i++) {
            int numberOfPeople = 0;
            int[] currentTimestamp = arr[i];
            if (currentTimestamp[2] == 1) {
                numberOfPeople = numberOfPeople + currentTimestamp[1];
            } else if (currentTimestamp[2] == 0) {
                numberOfPeople = numberOfPeople - currentTimestamp[1];
            }
            if (numberOfPeople > maxNumberOfPeople) {
                maxNumberOfPeople = numberOfPeople;
                currentTimeStamp = currentTimestamp[0];
            }
        }
        return currentTimeStamp;
    }

    public static void main(String[] args) {
//        String input ="xyyzpqzzywixyz";
//        char[] chars = new char[] {
//                'x','y','z'
//        };
//        System.out.println(getTheSmalledSubString(input, chars));

        int[][] input = new int[][] {
                {1487799425, 14, 1},
                {1487799425, 4,  0},
                {1487799425, 2,  0},
                {1487800378, 10, 1},
                {1487801478, 21, 0},
                {1487801478, 20, 1},
                {1487901013, 1,  0},
                {1487901211, 7,  1},
                {1487901211, 7,  0}

        };
        System.out.println(getTheNumberOfPeople(input));
    }
}

