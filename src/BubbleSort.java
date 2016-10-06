/**
 * Created by Nikhil on 10/5/16.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] input = {3, 2, 12,32,323,212,324,456,7577,7,2,34,10,0 ,5, 1, 0, 98, 78};
        BubbleSort obj = new BubbleSort();
        int[] output = obj.useBubbleSort(input);
        obj.arrayPrint(output);
    }

    public int[] useBubbleSort(int[] input) {
        if(input.length == 1) return input;
        for(int i=0; i<input.length-1;i++){
            for(int j=0;j<input.length-1;j++){
                if(input[j]>input[j+1]){
                    int temp = input[j];
                    input[j] =input[j+1];
                    input[j+1]= temp;
                }

            }
        }
        return input;
    }

    private void arrayPrint(int[] input){
        for(int i: input){
            System.out.print(i + " |");
        }
    }
}
