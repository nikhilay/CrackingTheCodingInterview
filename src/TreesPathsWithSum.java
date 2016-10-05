import java.util.HashMap;

/**
 * Created by Nikhil on 10/5/16.
 */
public class TreesPathsWithSum {

    public int countPath(MyBinaryTree.Node root, int targetSum) {
        if (root == null) {
            System.out.print("Tree is empty");
            return 0;
        }
        return countPath(root, targetSum, 0, new HashMap<Integer, Integer>());

    }

    private int countPath(MyBinaryTree.Node root, int targetSum, int runningSum, HashMap<Integer, Integer> hmap) {
        if (root == null) return 0;
        runningSum += root.nodeValue;
        int sum = runningSum - targetSum;
        int totalPaths = hmap.get(sum) == null ? 0 : hmap.get(sum);
        if (runningSum == targetSum) {
            totalPaths++;
        }

        incrementValue(hmap, runningSum, 1);
        totalPaths += countPath(root.leftChild, targetSum, runningSum, hmap);
        totalPaths += countPath(root.rightChild, targetSum, runningSum, hmap);
        incrementValue(hmap, runningSum, -1);
        return totalPaths;
    }

    private void incrementValue(HashMap<Integer, Integer> hmap, int runningSum, int delta) {
        int newCount = hmap.get(runningSum) == null ? 0 : hmap.get(runningSum) + delta;
        if (newCount == 0) {
            hmap.remove(runningSum);
        } else {
            hmap.put(runningSum, newCount);
        }
    }
}
