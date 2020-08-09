package biweekly30;

import java.util.HashMap;

public class ReformatDate {




    private static String reformatDate(String date) {
        StringBuilder sb = new StringBuilder();

        HashMap<String, Integer> months = new HashMap<>();
        months.put("Jan", 1);
        months.put("Fev", 2);
        months.put("Mar", 3);
        months.put("Apr", 4);
        months.put("May", 5);
        months.put("June", 6);
        months.put("July", 7);
        months.put("Aug", 8);
        months.put("Sept", 9);
        months.put("Oct", 10);
        months.put("Nov", 11);
        months.put("Dev", 12);


        String[] arr = date.split(" ");
        for (String str: arr) {
            try {
                if (Integer.parseInt(str) >= 1900 && Integer.parseInt(str) <= 2100) {
                    sb.append(str);
                    sb.append("-");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            if (months.get(str) != null) {
                sb.append(str);
                sb.append("-");
            }

            if (str.endsWith("st") || str.endsWith("th") || str.endsWith("nd") || str.endsWith("rd")) {
                sb.append(str.replace("st", ""));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reformatDate("26th May 1960"));
    }
}
