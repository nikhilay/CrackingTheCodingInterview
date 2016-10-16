import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by Nikhil on 10/14/16.
 */
public class DPMinimumCoins {

    public static void main(String[] args) {
        int[] denomination = {1, 5, 12, 25};
        new DPMinimumCoins().minimumNoOfCoins(denomination, 16);
    }

    public void minimumNoOfCoins(int[] denomination, int v) {
        int[] memo = new int[v + 1];
        memo[0] = 0;
        int[] coins = new int[v + 1];
        coins[0] = 0;
        for (int i = 1; i < memo.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int d : denomination) {
                if ((i - d) >= 0) {
                    if((memo[i-d]+1)<min){
                        min = memo[i-d]+1;
                        coins[i] = d;
                    }

                } else {
                    break;
                }
            }

            memo[i] = min;


        }
        System.out.print("Minimum number of coins is " + memo[v] + " for value " + v +" and the coins are ");
        int value = v;
        while(value>0){
            System.out.print( coins[value]+", ");
            value = value - coins[value];
        }

    }

}
