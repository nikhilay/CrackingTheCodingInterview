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
        int[][] memo = new int[matrixDimension.length ][matrixDimension.length ];
        for (int i = 0; i < memo.length; i++) {
            memo[i][i] = 0;
        }
        for (int k = 2; k < matrixDimension.length; k++) {
            for (int i = 1; i <= matrixDimension.length - k; i++) {
                int j = i + k - 1;
                int cost = Integer.MAX_VALUE;
                for (int l = i; l < j; l++) {
                    cost = Math.min(cost, memo[i][l] + memo[l + 1][j] + matrixDimension[i - 1] * matrixDimension[l] * matrixDimension[j]);

                }
                memo[i][j] = cost;
            }
        }
        System.out.println("Minimum number of multiplications is " + memo[1][matrixDimension.length-1]);

    }
}
