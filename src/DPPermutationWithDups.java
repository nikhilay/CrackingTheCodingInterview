import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Nikhil on 10/12/16.
 */
public class DPPermutationWithDups {
    public static void main(String[] args){
        HashSet<String> result = new DPPermutationWithDups().findAllPermutationWithDups("aab");
        for(String word: result){
            System.out.print(word+", ");
        }
    }

    private  HashSet<String> findAllPermutationWithDups(String word) {
        if (word == null) return null;
        HashSet<String> permutation = new HashSet<String>();
        if (word.length()==0) {
            permutation.add("");
            return permutation;
        }

        char c = word.charAt(0);
        String remaining = word.substring(1);
        HashSet<String> words = findAllPermutationWithDups(remaining);
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
