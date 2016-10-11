/**
 * Created by Nikhil on 10/11/16.
 */
public class DynamicProgrammingRodCuttingProblem {

    public static void main(String[] args) {
        int[] price = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int maximumCost = new DynamicProgrammingRodCuttingProblem().maximumRodCuttingCost(price, 12);
        System.out.println("Maximum Cost is " + maximumCost);

    }

    public int maximumRodCuttingCost(int[] price, int length) {
        if(length<=0) return 0;
        if(length> price.length) return 0;
        int[] memoizedCost = new int[length + 1];
        for (int i = 0; i < memoizedCost.length; i++) {
            memoizedCost[i] = -1;
        }
        return maximumRodCuttingCost(price, length, memoizedCost);
    }

    private int maximumRodCuttingCost(int[] price, int length, int[] memoizedCost) {
        if (memoizedCost[length] >= 0) return memoizedCost[length];
        int cost = -1;
        if (length == 0) {
            cost = 0;
        } else {
            for (int i = 1; i <=length; i++) {
                cost = Math.max(cost, price[i] + maximumRodCuttingCost(price, length - i, memoizedCost));
            }
            memoizedCost[length] = cost;
        }
        return cost;

    }
}
