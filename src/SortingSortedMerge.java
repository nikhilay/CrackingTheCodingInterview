/**
 * Created by Nikhil on 10/7/16.
 */
public class SortingSortedMerge {

    public static void main(String[] args) {
        int[] inputA = new int[13];
        int[] temp = {1, 4, 5, 23, 45, 321, 5423, 21213, 123456};
        int j = 0;
        for (int i : temp) {
            inputA[j] = i;
            j++;
        }
        int[] inputB = {8, 10, 18, 20};

        SortingSortedMerge obj = new SortingSortedMerge();
        obj.mergeSortedArrays(inputA, inputB, temp.length);

        for (int i : inputA) {
            System.out.print(i + " ,");
        }
    }

    public int[] mergeSortedArrays(int[] arrayA, int[] arrayB, int actualIndexA) {
        int indexA = actualIndexA - 1;
        int indexB = arrayB.length - 1;

        int mergedIndex = indexA + indexB + 1;

        while (indexB >= 0) {
            if (indexA >= 0 && arrayA[indexA] > arrayB[indexB]) {
                arrayA[mergedIndex] = arrayA[indexA];
                indexA--;
            } else {
                arrayA[mergedIndex] = arrayB[indexB];
                indexB--;

            }
            mergedIndex--;
        }
        return arrayA;
    }


}
