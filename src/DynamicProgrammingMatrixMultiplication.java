/**
 * Created by Nikhil on 10/11/16.
 */
public class DynamicProgrammingMatrixMultiplication {

    public static void main(String[] args) {
        int arr[] = new int[]{40, 20, 30, 10, 30};
        new DynamicProgrammingMatrixMultiplication().minimumMultiplicationCost(arr);
        new DynamicProgrammingMatrixMultiplication().efficientMatrixMultiplication(arr);
    }

    public void minimumMultiplicationCost(int arr[]) {
        int n = arr.length;

        System.out.println("Minimum number of multiplications is " +
                minimumMatrixMultiplicationCost(arr, 1, n - 1));
    }

    //Without using Dynamic Programming
    private int minimumMatrixMultiplicationCost(int[] matrixDimension, int start, int length) {
        if (start == length || length == 0 || length < 0) return 0;
        int cost = Integer.MAX_VALUE;
        for (int k = start; k < length; k++) {
            cost = Math.min(cost, minimumMatrixMultiplicationCost(matrixDimension, start, k)
                    +
                    minimumMatrixMultiplicationCost(matrixDimension, k + 1, length)
                    + matrixDimension[start - 1] * matrixDimension[k] * matrixDimension[length]);

        }
        return cost;
    }

    public void efficientMatrixMultiplication(int[] matrixDimension) {
        int[][] memo = new int[matrixDimension.length][matrixDimension.length];
        int[][] parenthesis = new int[matrixDimension.length][matrixDimension.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i][i] = 0;
        }
        for (int k = 2; k < matrixDimension.length; k++) {
            for (int i = 1; i <= matrixDimension.length - k; i++) {
                int j = i + k - 1;
                int cost = Integer.MAX_VALUE;
                int temp_computation;
                int l;
                for (l = i; l < j; l++) {
                    temp_computation = memo[i][l] + memo[l + 1][j] + matrixDimension[i - 1] * matrixDimension[l] * matrixDimension[j];
                    if (temp_computation<cost) {
                        memo[i][j] = temp_computation;
                        parenthesis[i][j] = l;
                        //System.out.println(i + " " + j + " " + l);
                    }
                }

            }
        }
        System.out.println("Minimum number of multiplications is " + memo[1][matrixDimension.length - 1]);
        parenthesisPrint(matrixDimension, parenthesis, 1, matrixDimension.length - 1);

    }

    public void parenthesisPrint(int[] matrixDimension, int[][] parenthesis, int i, int j) {
        if (i == j) {
            System.out.print(matrixDimension[i - 1] + " X " + matrixDimension[i]);
            return;
        } else {
            System.out.print("(");
            parenthesisPrint(matrixDimension, parenthesis, i, parenthesis[i][j]);
            System.out.print(")(");
            parenthesisPrint(matrixDimension, parenthesis, parenthesis[i][j] + 1, j);
            System.out.print(")");
            return;

        }

    }
}
