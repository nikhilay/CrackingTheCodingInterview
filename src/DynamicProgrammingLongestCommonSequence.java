/**
 * Created by Nikhil on 10/11/16.
 */
public class DynamicProgrammingLongestCommonSequence {
    public static void main(String[] args) {
        new DynamicProgrammingLongestCommonSequence().longestCommonSequence("donald", "nikhil");

    }

    public void longestCommonSequence(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            System.out.println("There is no longest common sequence  between " + str1 + " and " + str2);
            return;
        }
        int[][] memo = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length() + 1; i++) {
            for (int j = 0; j < str2.length() + 1; j++) {
                if (i == 0) {
                    memo[i][j] = 0;
                    continue;
                }
                if (j == 0) {
                    memo[i][j] = 0;
                    continue;
                }

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                    System.out.print(str1.charAt(i - 1) + " ");
                } else {
                    memo[i][j] = Math.max(memo[i][j - 1], memo[i - 1][j]);
                }

            }
        }
        System.out.print("\n");
        System.out.println("Length of longest common sequence is " + memo[str1.length()][str2.length()]);
    }
}
