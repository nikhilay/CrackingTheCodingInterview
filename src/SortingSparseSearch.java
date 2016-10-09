/**
 * Created by Nikhil on 10/9/16.
 */
public class SortingSparseSearch {
    public static void main(String[] args) {
        String[] input = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        new SortingSparseSearch().sparseSearch(input, "ball");
    }

    public void sparseSearch(String[] input, String str) {
        if (input.length == 0) return;
        int result = sparseSearch(input, str, 0, input.length - 1);
        if (result == -1) {
            System.out.println("String not found ");
        }
    }

    private int sparseSearch(String[] input, String str, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (input[mid].equals(str)) {
            System.out.println("Found the string \"" + input[mid] + "\"at index " + mid);
            return mid;
        }
        if (input[mid].isEmpty()) {
            int leftOfMid = mid - 1;
            int rightofMid = mid + 1;
            while (true) {
                if (leftOfMid < start && rightofMid > end) {
                    return -1;
                } else if (leftOfMid >= start && !input[leftOfMid].isEmpty()) {
                    mid = leftOfMid;
                    break;
                } else if (rightofMid <= end && !input[leftOfMid].isEmpty()) {
                    mid = rightofMid;
                    break;
                } else {
                    leftOfMid--;
                    rightofMid++;
                }
            }
        }

        if (input[mid].equals(str)) {
            System.out.println("Found the string \"" + input[mid] + "\" at index " + mid);
            return mid;
        } else if (str.compareTo(input[mid]) > 0) {
            return sparseSearch(input, str, mid + 1, end);
        } else {
            return sparseSearch(input, str, start, mid - 1);
        }

    }
}
