
/**
 * Created by Nikhil on 10/12/16.
 */
public class DynamicProgrammingMaximumContigiousSubsequence {

    public static void main(String[] args) {
        //-6,2,-4,1,3,-1,5,-1
        int[] input = {-6, 2, -4, 1, 3, -1, 5, -1};
        new DynamicProgrammingMaximumContigiousSubsequence().findMaxContigiousSum(input);
        new DynamicProgrammingMaximumContigiousSubsequence().findMaxContigiousSumUsingDP(input);

    }

    //O(n^2) time complexity
    public void findMaxContigiousSum(int[] input) {
        int startIndex = 0;
        int endIndex = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            int sum = 0;
            for (int j = i; j < input.length; j++) {
                sum = sum + input[j];
                if (sum > maxSum) {
                    startIndex = i;
                    endIndex = j;
                    maxSum = sum;

                }
            }
        }
        System.out.print("Maximum sum is " + maxSum + " for ");
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.print("\n");
    }

    //Dynamic programming \m/

    public void findMaxContigiousSumUsingDP(int[] input) {
        int[] maxSum = new int[input.length];
        int startIndex = 0;
        int finalStartIndex = 0;
        int finalendIndex = 0;
        int maxSubSequenceSum = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            if (i == 0) {
                maxSum[i] = input[i];
                if (maxSum[i] > maxSubSequenceSum) {
                    maxSubSequenceSum = maxSum[i];
                    startIndex = i;
                    finalStartIndex = i;
                    finalendIndex = i;
                }
                continue;
            }
            if (maxSum[i - 1] + input[i] > input[i]) {
                maxSum[i] = maxSum[i - 1] + input[i];
                if (maxSum[i] > maxSubSequenceSum) {
                    finalStartIndex = startIndex;
                    maxSubSequenceSum = maxSum[i];
                    finalendIndex = i;
                }

            } else {
                maxSum[i] = input[i];
                startIndex = i;
                if (maxSum[i] > maxSubSequenceSum) {
                    maxSubSequenceSum = maxSum[i];
                    finalStartIndex = startIndex;
                    finalendIndex = i;
                }

            }

        }
        System.out.print("Maximum sum is " + maxSubSequenceSum + " for ");
        for (int i = finalStartIndex; i <= finalendIndex; i++) {
            System.out.print(input[i] + ", ");
        }


    }


}
