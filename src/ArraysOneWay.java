/**
 * Created by Nikhil on 9/12/16.
 */
public class ArraysOneWay {
    public static void main(String[] args) {
        ArraysOneWay checkEdit = new ArraysOneWay();
        System.out.println(checkEdit.isOneWay("pales", "pale"));

    }

    public boolean isOneWay(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return checkOneEditReplace(s1, s2);
        } else if ((s1.length() + 1) == s2.length()) {
            return checkOneEditInsertRemoval(s2, s1);
        } else if (s1.length() == (s2.length() + 1)) {
            return checkOneEditInsertRemoval(s1, s2);
        } else {
            return false;
        }
    }

    public boolean checkOneEditReplace(String s1, String s2) {
        boolean difference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (difference) {
                    return false;
                }
                difference = true;
            }
        }
        return true;
    }

    public boolean checkOneEditInsertRemoval(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        boolean difference = false;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if(difference){
                    return false;
                }
                difference = true;
                index1++;

            } else {
                index1++;
                index2++;
            }
        }
        return  true;
    }
}
