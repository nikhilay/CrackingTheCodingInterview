/**
 * Created by Nikhil on 10/12/16.
 */
public class DPMagicIndex {

    public static void main(String[] args) {
        int[] input = {-10, -5, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        int[] inputWithDuplicates = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 13};
        new DPMagicIndex().findMagicIndex(input);
        new DPMagicIndex().findMagicIndexWithDuplicates(inputWithDuplicates);

    }

    public void findMagicIndex(int[] input) {
        int magicIndex = findMagicIndex(input, 0, input.length - 1);
        if (magicIndex != -1) {
            System.out.println("Magic Index is " + magicIndex);
        }
    }

    private int findMagicIndex(int[] input, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (input[mid] == mid) {
            return mid;
        } else if (input[mid] > mid) {
            return findMagicIndex(input, start, mid - 1);
        } else {
            return findMagicIndex(input, mid + 1, end);
        }

    }

    //follow up question with duplicate integers
    public void findMagicIndexWithDuplicates(int[] input) {
        int magicIndex = findMagicIndexWithDuplicates(input, 0, input.length - 1);
        if (magicIndex != -1) {
            System.out.println("Magic Index is " + magicIndex);
        }
    }

    private int findMagicIndexWithDuplicates(int[] input, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (input[mid] == mid) return mid;
        int leftIndex = Math.min(mid - 1, input[mid]);
        int left = findMagicIndexWithDuplicates(input, start, leftIndex);
        if (left >= 0) return left;
        int rightIndex = Math.max(mid + 1, input[mid]);
        int right = findMagicIndexWithDuplicates(input, rightIndex, end);
        if (right >= 0) return right;
        return -1;
    }

}
