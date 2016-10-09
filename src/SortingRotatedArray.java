/**
 * Created by Nikhil on 10/9/16.
 */
public class SortingRotatedArray {
    public static void main(String[] args){
        int[] input = {2,2,2,4,5,2};
        new SortingRotatedArray().searchInRotatedArray(input,2);
    }


    public void searchInRotatedArray(int[] input, int x) {
        if(input.length==0) return;
        int result = searchInRotatedArray(input, 0, input.length -1, x);
        if(result==-1){
            System.out.print("Element not found");
        }
    }


    private int searchInRotatedArray(int[] input, int start, int end, int x) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (input[mid] == x) {
            System.out.println("Found the element " + x);
            return input[mid];
        } else if (input[mid] < input[end]) {
            if (x > input[mid] && x < input[end]) {
                return searchInRotatedArray(input, mid + 1, end, x);
            } else {
                return searchInRotatedArray(input, start, mid - 1, x);
            }

        } else if (input[start] < input[mid]) {
            if (x >= input[start] && x < input[mid]) {
                return searchInRotatedArray(input, start, mid - 1, x);
            } else {
                return searchInRotatedArray(input, mid + 1, end, x);
            }
        } else if (input[start] == input[mid]) {
            if (input[mid] != input[end]) {
                return searchInRotatedArray(input, mid + 1, end, x);
            } else {
                int result = searchInRotatedArray(input, start, mid - 1, x);
                if (result == -1) {
                    return searchInRotatedArray(input, mid + 1, end, x);
                } else {
                    return result;

                }
            }
        }
        return -1;
    }
}
