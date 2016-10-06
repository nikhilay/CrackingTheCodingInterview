import java.util.LinkedList;

import static com.sun.tools.internal.xjc.reader.Ring.add;

/**
 * Created by Nikhil on 10/6/16.
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] input = {3, 2, 12,32,323,212,324,456,7577,7,2,34,10,0 ,5, 1, 0, 98, 78};
        RadixSort obj = new RadixSort();
        obj.useRadixSort(input);
        obj.arrayPrint(input);
    }

    private void arrayPrint(int[] input) {
        for (int i : input) {
            System.out.print(i + " |");
        }
    }

    public void useRadixSort(int[] input) {
        int max = getMaxNumber(input);
        int divider = 10;
        for (int exp = 1; max / exp > 0; exp *= 10) {
            LinkedList<Integer>[] sorter = new LinkedList[10];
            for (int i = 0; i < input.length; i++) {
                int index = ((input[i] % divider) / exp);
                if (sorter[index]==null) {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(input[i]);
                    sorter[index] = list;
                } else {
                    sorter[index].add(input[i]);
                }

            }
            divider *= 10;
            int index = 0;

            for (int i = 0; i < sorter.length; i++) {
                for (int j = 0; sorter[i]!=null && j<sorter[i].size(); j++) {
                    input[index] = sorter[i].get(j);
                    index++;
                }
            }
        }
    }

    private int getMaxNumber(int[] input) {
        int max = Integer.MIN_VALUE;
        for (int i : input) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
