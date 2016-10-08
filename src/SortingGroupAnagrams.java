import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * Created by Nikhil on 10/8/16.
 */
public class SortingGroupAnagrams {

    public static void main(String[] args) {
        String[] input = {"acer", "cow", "dog", "god", "nikhil", "race"};
        new SortingGroupAnagrams().sortGroupAnagrams(input);
        for (String word : input) {
            System.out.print(word + " ,");
        }
    }

    public void sortGroupAnagrams(String[] input) {
        LinkedHashMap<String, ArrayList<String>> lhmap = new LinkedHashMap<>();
        for (String s : input) {
            String sorted = getSorted(s);
            System.out.println(sorted);
            if (lhmap.containsKey(sorted)) {
                lhmap.get(sorted).add(s);
                lhmap.put(sorted, lhmap.get(sorted));
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                lhmap.put(sorted, list);
            }
        }
        int index = 0;
        for (String key : lhmap.keySet()) {
            ArrayList<String> temp = lhmap.get(key);
            for (String s : temp) {
                input[index] = s;
                index++;
            }
        }
    }

    private String getSorted(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}
