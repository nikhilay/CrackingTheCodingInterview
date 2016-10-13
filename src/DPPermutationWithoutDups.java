import java.util.ArrayList;

/**
 * Created by Nikhil on 10/12/16.
 */
public class DPPermutationWithoutDups {

    public static void main(String[] args){
        ArrayList<String> result = new DPPermutationWithoutDups().findAllPermutation("abc");
        for(String word: result){
            System.out.print(word+", ");
        }
    }

    public ArrayList<String> findAllPermutation(String word) {
        if (word == null) return null;
        ArrayList<String> permutation = new ArrayList<String>();
        if (word.length()==0) {
            permutation.add("");
            return permutation;
        }

        char c = word.charAt(0);
        String remaining = word.substring(1);
        ArrayList<String> words = findAllPermutation(remaining);
        for (String str : words) {
            for (int j = 0; j <= str.length(); j++) {
                String s = insertAtChar(str, j, c);
                permutation.add(s);
            }
        }
        return permutation;
    }

    private String insertAtChar(String word, int position, char c){
        return word.substring(0,position)+c+word.substring(position);
    }
}
