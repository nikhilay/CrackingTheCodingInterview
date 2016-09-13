/**
 * Created by Nikhil on 9/12/16.
 */
public class ArraysStringCompression {
    public static void main(String[] args) {
        ArraysStringCompression strCompression = new ArraysStringCompression();
        System.out.println(strCompression.compressedString("aabcccccaaa"));
    }

    public String compressedString(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            count++;
            if ((i + 1) >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(s.charAt(i));
                sb.append(count);
                count = 0;
            }
        }
        return sb.length() < s.length() ? sb.toString() : s;
    }
}
