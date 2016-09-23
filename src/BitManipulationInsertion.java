/**
 * Created by Nikhil on 9/22/16.
 */
public class BitManipulationInsertion {

    public static void main(String[] args){
        BitManipulationInsertion bmi = new BitManipulationInsertion();
        System.out.println(bmi.updateBits(189,4,4,2));
    }

    public int updateBits(int n, int m, int j, int i) {
        int allOnes = ~0;
        int left = allOnes << j + 1;
        int right = (1<<i)-1;
        int mask = left | right;
        int n_cleared = mask & n;
        int m_shifted = m << i;
        return n_cleared | m_shifted;
    }
}
