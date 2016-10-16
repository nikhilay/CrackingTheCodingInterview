import java.util.Arrays;

/**
 * Created by Nikhil on 10/16/16.
 */
public class DPCoins {

    public static void main(String[] args) {
        int[] denomination = {1,2, 3};
        new DPCoins().makeChange(5, denomination);
    }

    public void makeChange(int value, int[] denomination) {
        int[][] map = new int[value+1][denomination.length];
        for(int[] row:map) {
            Arrays.fill(row, -1);
        }
        int noOfWays = makeChange(value, denomination, 0,map);
        System.out.println("No of ways to represent " + value + " is " + noOfWays);
        for(int i =0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.print("\n");
        }

    }

    private int makeChange(int value, int[] denomination, int index, int[][] map) {
        if (value == 0) return 1;
        if (index == denomination.length - 1 && value == denomination[index]){
            return 1;
        }else if(index == denomination.length - 1 && value != denomination[index]){
            return 0;
        }
        if(map[value][index]>=0){
            System.out.println("sa");
            return map[value][index];
        }

        int ways = 0;
        for (int i = 0; i *denomination[index]<=value; i++) {
            int remainingAmount = value - i * denomination[index];
            ways += makeChange(remainingAmount, denomination, index + 1,map);
        }
        map[value][index] = ways;
        return ways;
    }
}
