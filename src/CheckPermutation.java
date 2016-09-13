/**
 * Created by Nikhil on 9/12/16.
 */
public class CheckPermutation {
    public static void main(String[] args) {
        CheckPermutation check = new CheckPermutation();
        System.out.println(check.arePermutationOfEachOther("nikhil", "likhin"));

    }

    public boolean arePermutationOfEachOther(String input1, String input2) {
        if (input1.length() != input2.length()) {
            return false;
        }

        int[] letters = new int[128];

        for (char c : input1.toCharArray()) {
            letters[(int) c]++;
        }

        for (char c : input2.toCharArray()) {
            letters[(int) c]--;
            if (letters[(int) c] < 0) {
                return false;
            }
        }
        return true;
    }
}
