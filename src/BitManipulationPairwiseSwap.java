/**
 * Created by Nikhil on 9/23/16.
 */
public class BitManipulationPairwiseSwap {
public static void main(String[] args){
    BitManipulationPairwiseSwap obj = new BitManipulationPairwiseSwap();
    obj.pairwiseSwap(127);

}
    public void pairwiseSwap(int input) {
        System.out.println("Before Swapping " + Integer.toBinaryString(input));
        int result = ((input & 0xaaaaaaaa) >>> 1) | ((input & 0x55555555) << 1);
        System.out.println("After Swapping " + Integer.toBinaryString(result));
    }
}
