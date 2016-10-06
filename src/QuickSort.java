/**
 * Created by Nikhil on 10/6/16.
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] input = {3, 2, 12,32,323,212,324,456,7577,7,2,34,10,0 ,5, 1, 0, 98, 78};
        QuickSort obj = new QuickSort();
        int[] output = obj.useQuickSort(input);
        obj.arrayPrint(output);

    }

    public int[] useQuickSort(int[] input) {
        if(input.length==1) return input;
        quickSort(input, 0, input.length - 1);
        return  input;
    }

    private void quickSort(int[] input, int start, int end) {
        if (start > end) {
            return;
        }
        int pivotIndex = partitioning(input, start, end);
        quickSort(input, start, pivotIndex - 1);
        quickSort(input, pivotIndex + 1, end);
    }

    private int partitioning(int[] input, int start, int end){
        int pivotIndex = start;

        for(int i=start; i<end; i++){
            if(input[i]<input[end]){
                int temp = input[pivotIndex];
                input[pivotIndex] = input[i];
                input[i] = temp;
                pivotIndex++;

            }
        }
        int tempPivotSwap = input[pivotIndex];
        input[pivotIndex] = input[end];
        input[end] = tempPivotSwap;
        return pivotIndex;

    }
    private void arrayPrint(int[] input){
        for(int i: input){
            System.out.print(i + " |");
        }
    }
}
