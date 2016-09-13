import java.util.HashSet;

/**
 * Created by Nikhil on 9/11/16.
 */
public class ArraysIsUnique {
    public static void main(String[] args) {
        ArraysIsUnique input = new ArraysIsUnique();
        System.out.println(input.isUnique("Shalen"));
    }

    public boolean isUnique(String input) {
        if (input == null || input.equals("")) {
            return false;
        }
        HashSet isInSet = new HashSet();
        for (int i = 0; i < input.length(); i++) {
            char element = input.charAt(i);
            if (isInSet.contains(element) == false) {
                isInSet.add(element);
            } else {
                return false;
            }
        }

        return true;
    }
}
