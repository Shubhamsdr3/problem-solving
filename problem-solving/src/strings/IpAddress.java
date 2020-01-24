package strings;

public class IpAddress {

    public static String defangIPaddr(String address) {

        String string = "";

        for (int i=0; i < address.length(); i++) {
            string = address.replace("" + '.',  "[.]");
        }

        return string;
    }

    public static void main(String[] args) {
        String address = "255.100.50.0";
        System.out.println(defangIPaddr(address));
    }
}
