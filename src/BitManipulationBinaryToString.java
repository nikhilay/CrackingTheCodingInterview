/**
 * Created by Nikhil on 9/22/16.
 */
public class BitManipulationBinaryToString {

    public static void main(String[] args) {
        BitManipulationBinaryToString ob = new BitManipulationBinaryToString();
        System.out.println(ob.binaryToString(0.252));

    }

    public String binaryToString(double input) {
        if (input >= 1 || input <= 0) {
            return "ERROR";
        }
        StringBuilder st = new StringBuilder();
        while (input > 0) {
            if (st.length() > 32) {
                return st.toString();
            }
            input = input * 2;
            if (input >= 1) {
                st.append('1');
                input--;
            } else {
                st.append('0');
            }

        }
        return st.toString();
    }
}
