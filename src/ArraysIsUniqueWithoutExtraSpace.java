/**
 * Created by Nikhil on 9/12/16.
 */
public class ArraysIsUniqueWithoutExtraSpace {
    public static void main(String[] args) {
        ArraysIsUniqueWithoutExtraSpace input = new ArraysIsUniqueWithoutExtraSpace();
        System.out.println(input.isUnique("Shalen"));

    }

    public boolean isUnique(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
