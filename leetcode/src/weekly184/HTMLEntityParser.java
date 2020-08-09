package weekly184;

import java.util.HashMap;
import java.util.Map;

public class HTMLEntityParser {

    private static String entityParser(String text) {
        HashMap<String,Character> map = new HashMap<>();
        String result = text;
        map.put("&quot;", '\"');
        map.put("&apos;", '\'');
        map.put("&amp;", '&');
        map.put("&gt;", '>');
        map.put("&lt;", '<');
        map.put("&frasl;", '/');

        for (Map.Entry<String, Character> entry: map.entrySet()) {
            if (text.contains(entry.getKey())) {
               result = result.replaceAll(entry.getKey(), entry.getValue()+"");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "x &gt; y &amp;&amp; x &lt; y is always false";
        System.out.println(entityParser(input));
    }
}
