/**
 * Created by Nikhil on 9/22/16.
 */
public class BitManipulationConversion {
    public static void main(String[] args) {
        BitManipulationConversion obj = new BitManipulationConversion();
        obj.noOfFlips(58954123, 4);

    }


    public int noOfFlips(int input1, int input2) {

        int count = 0;

        for (int c = input1 ^ input2; c > 0; c = c >>> 1) {
            count = count + (c & 1);
        }
        System.out.println("No of bits to be flipped is " + count);
        return count;

    }
}
