/**
 * Created by Nikhil on 10/12/16.
 */
public class SortingDuplicates {
    public static void main(String[] args) {
        int[] input = {1, 3, 4, 2, 23, 435, 2, 1, 1, 1, 5, 6, 6, 7, 3, 4, 56, 7, 7, 44, 4, 4, 4, 4};
        new SortingDuplicates().printAllDuplicates(input);
    }

    public void printAllDuplicates(int[] array) {
        byte[] bitfield = new byte[(int) ((32000 + 1) / 8)];
        System.out.print("Duplicates are ");
        for (int i : array) {
            byte number = bitfield[i / 8];
            if ((number & 1 << (i % 8)) == 0) {
                bitfield[i / 8] |= 1 << (i % 8);
            } else {
                System.out.print(i + ", ");
            }

        }


    }
}
