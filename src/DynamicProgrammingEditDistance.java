/**
 * Created by Nikhil on 10/11/16.
 */
public class DynamicProgrammingEditDistance {

    public static void main(String[] args) {
        new DynamicProgrammingEditDistance().inefficientEditDistance("donald trump", "stupid");
        new DynamicProgrammingEditDistance().editDistance("donald trump", "stupid");
    }

    public void inefficientEditDistance(String str1, String str2) {
        int result = inefficientEditDistance(str1, str1.length(), str2, str2.length());
        System.out.println("Distance between " + str1 + " and " + str2 + " is " + result);
    }

    //exponential time complexity
    private int inefficientEditDistance(String changetoStr, int changetoStrLength, String str, int strLength) {
        if (strLength == 0) return changetoStrLength;

        if (changetoStrLength == 0) return strLength;

        if (changetoStr.charAt(changetoStrLength - 1) == str.charAt(strLength - 1)) {
            return inefficientEditDistance(changetoStr, changetoStrLength - 1, str, strLength - 1);

        } else {
            return 1 + minValue(inefficientEditDistance(changetoStr, changetoStrLength, str, strLength - 1),
                    inefficientEditDistance(changetoStr, changetoStrLength - 1, str, strLength),
                    inefficientEditDistance(changetoStr, changetoStrLength - 1, str, strLength - 1));
        }
    }

    private int minValue(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }

    //Dynamic Programming yay \m/

    public void editDistance(String from, String to) {
        int[][] memo = new int[from.length() + 1][to.length() + 1];
        for (int i = 0; i < from.length()+1; i++) {
            for (int j = 0; j < to.length()+1; j++) {
                if(i==0){
                    memo[i][j] = j;
                    continue;
                }
                if(j==0){
                    memo[i][j]=i;
                    continue;
                }

                if(from.charAt(i-1)==to.charAt(j-1)){
                    memo[i][j] =memo[i-1][j-1];
                }else{
                    memo[i][j]= 1+minValue(memo[i-1][j-1], memo[i][j-1],memo[i-1][j]);
                }
            }
        }
        System.out.println("Distance between " + from + " and " + to+ " is " + memo[from.length()][to.length()]);

    }


}
