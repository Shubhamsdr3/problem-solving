package strings;

public class SeprateTheNumber {

    //TODO:SHUBHAM
    private static void separateNumbers(String s) {
        if (s.length() <= 2) {
            System.out.println("NO");
            return;
        }
        String res = "";
        boolean isSomething = false;
        String some = "";
        for (int i=0; i < s.length() /2; i++) {
            StringBuilder prevString = new StringBuilder();
            if (isSomething) {
                prevString.append(s, i, i +1);
            } else {
                prevString.append(s, 0, i +1);
            }
            StringBuilder stringBuilder  = new StringBuilder();
            if (i < s.length() -1) {
                stringBuilder.append(s, i +1, i+2);
            }
            for (int j = i+1; j < s.length() /2; j++ ) {
                if (Double.parseDouble(stringBuilder.toString()) - Double.parseDouble(prevString.toString()) == 1) {
                    if (!isSomething) {
                        some = prevString.toString();
                    }
                    res = "YES " + some;
                    isSomething = true;
                    break;
                } else if (j < s.length() -1){
                    if (Double.parseDouble(stringBuilder.toString().substring(0, 1)) == 0) {
                        break;
                    }
                    stringBuilder.append(s, j +1, j+2);
                    res = "NO";
                }
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        String number = "99910001001";
        String number1 = "7891011";
        String number2  = "9899100";
        String number3 = "999100010001";

//        separateNumbers(number);
//        separateNumbers(number1);
//        separateNumbers(number2);
        separateNumbers(number3);

//        separateNumbers("010203");
//        separateNumbers("13");
//        separateNumbers("1");

//        separateNumbers("99910001001");
//
//        separateNumbers("999100010001");
    }
}
