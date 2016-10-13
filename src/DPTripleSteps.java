/**
 * Created by Nikhil on 10/12/16.
 */
public class DPTripleSteps {

    public static void main(String[] args) {
        new DPTripleSteps().countNoOfWays(4);

    }

    public void countNoOfWays(int n) {
        int[] memo = new int[n+1];
        int noOfWays = countNoOfWays(n, memo);
        System.out.println("Number of ways to reach "+ n +" is "+noOfWays);
    }

    private int countNoOfWays(int n, int[] memo) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if(memo[n]>0) return memo[n];
        memo[n] = countNoOfWays(n - 1, memo) + countNoOfWays(n - 2, memo) + countNoOfWays(n - 3, memo);
        return memo[n];
    }
}
