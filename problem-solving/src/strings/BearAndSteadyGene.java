package strings;

import java.util.HashMap;
import java.util.Map;

public class BearAndSteadyGene {

    /**
     * ACTG:
     * @param gene
     * @return
     */
    //TODO:FIXME
    private static int steadyGene(String gene) {
        String string = "CGAT";
        Map<Character, Integer> characters = new HashMap<>();
        for (char c: string.toCharArray()) {
            characters.put(c, 0);
        }
        for (int i=0; i < gene.length(); i++) {
            char c = gene.charAt(i);
            if (characters.containsKey(c)) {
                int value = characters.get(c);
                characters.put(c, ++value);
            } else {
                characters.put(c, 1);
            }
        }
        int result = 0;
        for (Map.Entry<Character, Integer> entry: characters.entrySet())  {
            if (entry.getValue() != gene.length() % 4) {
                result = result +  entry.getValue();
            } else if (entry.getValue() == 0) {
                result = result -  2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String string = "GAAATAAA";
        String string1 = "TGATGCCGTCCCCTCAACTTGAGTGCTCCTAATGCGTTGC";
        System.out.println(steadyGene(string));
    }
}
