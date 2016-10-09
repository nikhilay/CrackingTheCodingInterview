import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by Nikhil on 10/9/16.
 */
public class SortingSearchNoSize {
    private static final int VALUE_AT_ARRAY_OUT_OF_BOUND = -1;

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        new SortingSearchNoSize().searchElement(input, 11);
    }

    public void searchElement(int[] input, int x) {
        int index = 1;
        try {
            while (input[index - 1] != -1 && input[index - 1] < x) {
                index *= 2;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //Used try and catch because as per question a custome data structure was asked to used where
            // if its is out of bound, it should return -1. So, to deal with that, I am using exception
        }

        int result = searchInBinary(input, (index / 2) - 1, index - 1, x);
        if (result == VALUE_AT_ARRAY_OUT_OF_BOUND) {
            System.out.println("Element not found");
        }
    }

    private int searchInBinary(int[] input, int start, int end, int x) {
        int mid = (start + end) / 2;
        if (start > end) {
            return VALUE_AT_ARRAY_OUT_OF_BOUND;
        }
        try {
            if (input[mid] == VALUE_AT_ARRAY_OUT_OF_BOUND) {

            } else if (input[mid] == x) {
                System.out.println("Found the element " + input[mid]);
                return input[mid];
            } else if (x > input[mid]) {
                return searchInBinary(input, mid + 1, end, x);
            } else if (x < input[mid]) {
                return searchInBinary(input, start, mid - 1, x);
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            return searchInBinary(input, start, mid - 1, x);
        }
        return VALUE_AT_ARRAY_OUT_OF_BOUND;
    }
}
