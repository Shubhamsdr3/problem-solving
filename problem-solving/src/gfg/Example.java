package gfg;

import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) {
        String firstString = "Test123";
        String secondString = "Test123";
        String thirdString = new String("Test123");

        System.out.println(firstString == secondString);
        System.out.println(firstString == thirdString);
        String str = null;
        System.out.println(firstString.equals(str));
    }
}
