/**
 * Created by Nikhil on 10/1/16.
 */
public class TreesCheckBalanced {

    public static void main(String[] args) {
        TreesCheckBalanced obj = new TreesCheckBalanced();
        MyBinaryTree tree = new MyBinaryTree();
        tree.addNode(40);
        tree.addNode(30);
        tree.addNode(60);
        tree.addNode(20);
        tree.addNode(35);
        tree.addNode(50);
        tree.addNode(70);
        tree.addNode(10);
        tree.addNode(1);
        System.out.println(obj.checkBalanced(tree.root));
    }

    public boolean checkBalanced(MyBinaryTree.Node root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return true;
        }
        int result = isBalanced(root);

        return result < 0 ? false : true;
    }

    private int isBalanced(MyBinaryTree.Node focusNode) {
        if (focusNode == null) {
            return 0;
        }
        int leftHeight = isBalanced(focusNode.leftChild);
        int rightHeight = isBalanced(focusNode.rightChild);

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            System.out.println("Tree is not balanced");
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;

    }
}
