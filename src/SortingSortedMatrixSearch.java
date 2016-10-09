

/**
 * Created by Nikhil on 10/9/16.
 */
public class SortingSortedMatrixSearch {

    public static void main(String[] args) {
        int[][] inputMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new SortingSortedMatrixSearch().searchInSortedMatrix(inputMatrix, 7);
    }

    public void searchInSortedMatrix(int[][] inputMatrix, int x) {
        int col = inputMatrix[0].length - 1;
        int row = 0;
        while (row < inputMatrix.length && col >= 0) {
            if (inputMatrix[row][col] == x) {
                System.out.println("Found the number " + inputMatrix[row][col]);
                return;
            } else if (x < inputMatrix[row][col]) {
                col--;
            } else {
                row++;
            }

        }
        System.out.println("Not found ");

    }
}
