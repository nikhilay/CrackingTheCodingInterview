/**
 * Created by Nikhil on 9/12/16.
 */
public class ArraysUrlify {
    public static void main(String[] args) {
      ArraysUrlify ob = new ArraysUrlify();
        System.out.println(ob.toURLify("Mr John Smith                  ",13));
    }

    public String toURLify(String s, int trueLength) {
        char[] input = s.toCharArray();
        int whiteSpaces = 0;
        for (int i = 0; i < trueLength; i++) {
            if (String.valueOf(input[i]).equals(" ")) {
                whiteSpaces++;
            }
        }

        int newlength = trueLength + whiteSpaces * 2;

        for (int i = trueLength - 1; i >= 0; i--) {
            if (String.valueOf(input[i]).equals(" ")) {
                input[newlength - 1] = '0';
                input[newlength - 2] = '2';
                input[newlength - 3] = '%';
                newlength = newlength - 3;
            } else {
                input[newlength - 1] = input[i];
                newlength--;
            }
        }
        return String.valueOf(input);
    }
}
