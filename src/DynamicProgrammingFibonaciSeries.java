import static javafx.scene.input.KeyCode.R;

/**
 * Created by Nikhil on 10/10/16.
 */
public class DynamicProgrammingFibonaciSeries {

    public static void main(String[] args) {
        int normalResult = new DynamicProgrammingFibonaciSeries().normalFibonacciSeries(20);
        int bottomUpResult = new DynamicProgrammingFibonaciSeries().bottomUpFibonacciSeries(60);
        int topDownResult = new DynamicProgrammingFibonaciSeries().topDownFibonacci(60);
        System.out.println(normalResult);
        System.out.println(bottomUpResult);
        System.out.println(topDownResult);
    }

    //normal fibonacci series with 2^n time complexity
    public int normalFibonacciSeries(int input) {
        if (input == 0) return 0;
        if (input == 1) return 1;

        return normalFibonacciSeries(input - 1) + normalFibonacciSeries(input - 2);
    }
    //bottom up approach O(n) time complexity and O(n) space

    public int bottomUpFibonacciSeries(int x) {
        int[] result = new int[x + 1];
        return bottomUpFibonacciSeries(x, result);
    }

    private int bottomUpFibonacciSeries(int x, int[] result) {
        result[0] = 0;
        result[1] = 1;
        if (x == 0) return 0;
        if (x == 1) return 1;
        for (int i = 2; i <= x; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[x];
    }

    //top Down approach O(n) time complexity

    public int topDownFibonacci(int n) {
        int[] result = new int[n + 1];
        return topDownFibonacci(n, result);
    }

    public int topDownFibonacci(int n, int[] memo) {
        if (n == 0 || n == 1) return n;
        if (memo[n] == 0) {
            memo[n] = topDownFibonacci(n - 1, memo) + topDownFibonacci(n - 2, memo);
        }
        return memo[n];
    }
}
