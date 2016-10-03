import java.util.HashMap;

/**
 * Created by Nikhil on 10/3/16.
 */
public class LeetCodeSingleNumber {
    //naive solution with memory
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hmap.containsKey(nums[i])) {
                hmap.put(nums[i], 1);
            } else {
                hmap.put(nums[i], hmap.get(nums[i]) + 1);
            }
        }
        for (Integer result : hmap.keySet()) {
            if (hmap.get(result) == 1) {
                return result;
            }
        }
        return 0;
    }

    //without memory

    public int singleNumberWithoutMemory(int[] nums) {
        int x = 0;
        for (int a : nums) {
            x = x ^ a;
        }
        return x;
    }
}
