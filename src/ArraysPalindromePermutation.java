/**
 * Created by Nikhil on 9/12/16.
 */
public class ArraysPalindromePermutation {
    public static void main(String[] args){
    ArraysPalindromePermutation ob = new ArraysPalindromePermutation();
        System.out.println(ob.isPalindromePermutation("nitin ll  "));
    }

    public boolean isPalindromePermutation(String s){
        s = s.toLowerCase();
        s = s.replaceAll("\\s","");
        int[] countOfLetter = new int[Character.getNumericValue('z') -  Character.getNumericValue('a') + 1];
        int oddCount = 0;
        for (int i = 0; i<s.length(); i++){
            int index = Character.getNumericValue(s.charAt(i)) - Character.getNumericValue('a');
            countOfLetter[index]++;
            if(countOfLetter[index]%2 == 1){
               oddCount++;
            }else {
                oddCount--;
            }
        }
        return oddCount <= 1;
    }
}
