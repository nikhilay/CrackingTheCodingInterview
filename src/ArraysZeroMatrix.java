/**
 * Created by Nikhil on 9/13/16.
 */
public class ArraysZeroMatrix {
    public static void main(String[] args) {
      ArraysZeroMatrix ob = new ArraysZeroMatrix();
        int[][] inputMatrix = {{2,3,5},{10,0,7},{11,9,8}};
        int[][] outputMatrix = ob.makeZeroMatrix(inputMatrix);
        for (int i = 0; i < outputMatrix.length; i++) {
            for (int j = 0; j < outputMatrix[0].length; j++) {
                System.out.print(outputMatrix[i][j]+" |");
            }
            System.out.print("\n");
        }
    }

    public int[][] makeZeroMatrix(int[][] inputMatrix) {
        boolean[] row = new boolean[inputMatrix.length];
        boolean[] column = new boolean[inputMatrix[0].length];

        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[0].length; j++) {
                if (inputMatrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                inputMatrix = nullifyRow(inputMatrix, i);
            }
        }

        for (int j = 0; j < column.length; j++) {
            if (column[j]) {
                inputMatrix = nullifyColumn(inputMatrix, j);
            }
        }

        return inputMatrix;
    }

    public int[][] nullifyRow(int[][] inputMatrix, int rowNumber) {
        for (int j = 0; j < inputMatrix[rowNumber].length; j++) {
            inputMatrix[rowNumber][j] = 0;
        }
        return inputMatrix;
    }

    public int[][] nullifyColumn(int[][] inputMatrix, int columnNumber) {
        for (int i = 0; i < inputMatrix.length; i++) {
            inputMatrix[i][columnNumber] = 0;
        }
        return inputMatrix;
    }
}
