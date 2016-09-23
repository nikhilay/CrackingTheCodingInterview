import org.omg.CORBA.MARSHAL;

/**
 * Created by Nikhil on 9/23/16.
 */
public class BitManipulationFlipBitToWin {

    public static void main(String[] args) {
BitManipulationFlipBitToWin obj = new BitManipulationFlipBitToWin();
        System.out.println(obj.flipBitToWin(-1));
    }

    public int flipBitToWin(int input) {
        if (~input == 0) {
            return Integer.SIZE;
        }
        int maxLength = 0;
        int previousLength = 0;
        int currentLength = 0;

        while (input != 0) {
            if ((input & 1) == 1) {
                currentLength++;
            } else {
                previousLength = ((input & 2) == 0 ?0:currentLength);
                currentLength =0 ;
            }
            maxLength = Math.max(currentLength + previousLength+1,maxLength);
            input = input >>> 1;
        }
        return (maxLength );
    }
}
