import java.util.HashMap;

import static com.sun.tools.javac.jvm.ByteCodes.ret;

/**
 * Created by Nikhil on 10/14/16.
 */
public class DPMinimumCoins {

//    public static void main(String[] args) {
//
//    }
//
//    public int minimumNoOfCoins(int[] denomination,int v) {
//        int[] memo = new int[v+1];
//        memo[0] =0;
//        for(int i=1;i<memo.length;i++){
//            int min;
//            for(int d:denomination){
//               if((i-d)>=0){
//                   min = memo[i-d]+1;
//               }
//            }
//        }
//
//
//    }

    public int majorityElement(int[] nums) {

        HashMap<Integer,Integer> hmap = new HashMap<>();

        for(int i:nums){
            if(hmap.containsKey(i)){
                int count = hmap.get(i)+1;
                if((count)>(nums.length/2)){
                    return i;
                }
                hmap.put(i,count);

                continue;
            }
            hmap.put(i,1);
        }
        return 0;
    }
}
