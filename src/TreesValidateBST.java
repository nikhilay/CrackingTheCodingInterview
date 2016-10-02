/**
 * Created by Nikhil on 10/1/16.
 */
public class TreesValidateBST {
    public boolean validateBST(MyBinaryTree.Node root) {
        boolean result = checkBST(root, null, null);
        return result ? true : false;

    }

    private boolean checkBST(MyBinaryTree.Node node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if ((min!=null && node.nodeValue < min) || (max!=null && node.nodeValue > max)) {
            return false;
        }

        if (!(checkBST(node.leftChild, min, node.nodeValue)) || !(checkBST(node.rightChild, node.nodeValue, max))) {
            return false;
        }
        return true;

    }
}
