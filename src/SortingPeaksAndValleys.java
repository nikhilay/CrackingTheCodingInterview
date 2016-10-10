import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;


/**
 * Created by Nikhil on 10/9/16.
 */
public class SortingPeaksAndValleys {
    public static void main(String[] args) {
        int[] input = {3, 0, 1, 4, 2,2};
        new SortingPeaksAndValleys().sortForPeaksAndValleys(input);
        new SortingPeaksAndValleys().efficientSortingForPeakAndValley(input);
    }

    //O(nLogn) time complexity because of sorting
    public void sortForPeaksAndValleys(int[] input) {
        Arrays.sort(input);
        for (int i = 1; i < input.length; i += 2) {
            swapNumbers(input, i, i - 1);
        }
        for (int i : input) {
            System.out.print(i + " ,");
        }
    }

    private void swapNumbers(int[] input, int left, int right) {
        int temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }

    //O(n) time complexity
    public void efficientSortingForPeakAndValley(int[] input) {
        for (int i = 1; i < input.length; i += 2) {
            int smallestIndex = smallestIndex(input, i - 1, i, i + 1);
            if (input[i] != input[smallestIndex]) {
                swapNumbers(input, smallestIndex, i);
            }
        }
        System.out.print("\n");
        for (int i : input) {
            System.out.print(i + " ,");
        }
    }

    private int smallestIndex(int[] input, int left, int mid, int right) {
        int len = input.length;
        int leftValue = left >= 0 && left < len ? input[left] : Integer.MAX_VALUE;
        int midValue = mid >= 0 && mid < len ? input[mid] : Integer.MAX_VALUE;
        int rightValue = right >= 0 && right < len ? input[right] : Integer.MAX_VALUE;
        int smallestValue = Math.min(leftValue, Math.min(midValue, rightValue));
        if (smallestValue == leftValue) {
            return left;
        } else if (smallestValue == midValue) {
            return mid;
        } else {
            return right;
        }


    }
}
