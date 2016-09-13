/**
 * Created by Nikhil on 9/12/16.
 */

import java.lang.reflect.Array;
import java.util.Arrays;

public class CheckPermutationUsingSorting {
    public static void main(String[] args) {
        CheckPermutationUsingSorting check = new CheckPermutationUsingSorting();
        System.out.println(check.arePermutationOfEachOther("nikhil", "likhin"));

    }

    public boolean arePermutationOfEachOther(String input1, String input2) {
        if (input1.length() != input2.length()) {
            return false;
        }

        if (input1.equals(input2)) {
            return true;
        }

        return false;
    }

   // public String sort(String s) {
    //    return String.valueOf(Arrays.sort(s.toCharArray()));
   // }
}
