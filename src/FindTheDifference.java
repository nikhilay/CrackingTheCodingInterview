import java.util.HashMap;

/**
 * Created by Nikhil on 10/10/16.
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {

        HashMap<Character, Integer> hmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (!hmap.containsKey(letter)) {
                hmap.put(letter, 1);
            } else {
                hmap.put(letter, hmap.get(letter) + 1);
            }
        }

        for (int j = 0; j < t.length(); j++) {
            char letter = t.charAt(j);
            if (!hmap.containsKey(letter)) {
                return letter;
            } else {
                hmap.put(letter, hmap.get(letter) - 1);
            }

        }

        for (Character c : hmap.keySet()) {
            if (hmap.get(c) > 0) {
                return c;
            }
        }
        return 'a';
    }
}
