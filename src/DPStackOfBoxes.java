import org.omg.PortableInterceptor.INACTIVE;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.Callable;

/**
 * Created by Nikhil on 10/16/16.
 */
public class DPStackOfBoxes {
    class Box {
        int height;
        int length;
        int width;
        int size;

        Box(int height, int length, int width) {
            this.height = height;
            this.length = length;
            this.width = width;
            size = height * length;
        }
    }


    public void findMaxHeight(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());
        int maxHeight = Integer.MIN_VALUE;
        int[] memo = new int[boxes.size()];
        Arrays.fill(memo, -1);
        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i, memo);
            maxHeight = Math.max(height, maxHeight);
        }
        System.out.println("Maximun height is " + maxHeight);
    }

    private int createStack(ArrayList<Box> boxes, int bottomIndex, int[] memo) {
        if (bottomIndex < boxes.size() && memo[bottomIndex] > 0) {
            return memo[bottomIndex];
        }
        int maxHeight = Integer.MIN_VALUE;
        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (isLesser(boxes.get(bottomIndex), boxes.get(i))) {
                int height = createStack(boxes, bottomIndex + 1, memo);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight += boxes.get(bottomIndex).height;
        memo[bottomIndex] = maxHeight;
        return maxHeight;

    }

    private boolean isLesser(Box b1, Box b2) {
        return (b1.length * b1.width) > (b2.length * b2.width);

    }

    class BoxComparator implements Comparator<Box> {

        @Override
        public int compare(Box o1, Box o2) {
            return o2.height - o1.height;
        }
    }


}
