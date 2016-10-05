import java.util.Random;

/**
 * Created by Nikhil on 10/5/16.
 */
public class TreeGetRandomNode {

    public void getRandomNode(MyBinaryTree.Node root) {
        int leftSize = root.leftChild == null ? 0 : root.leftChild.size;
        Random random = new Random();
        int index = random.nextInt();

        if (index == leftSize) {
            System.out.print("Random Node is " + root.leftChild.nodeValue);
        } else if (index < leftSize) {
            getRandomNode(root.leftChild);
        } else {
            getRandomNode(root.rightChild);
        }
    }
}
