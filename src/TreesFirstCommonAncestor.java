/**
 * Created by Nikhil on 10/3/16.
 */
public class TreesFirstCommonAncestor {


    //Solution one where links to its parent is given
    public MyBinaryTree.Node firstCommonAncestor(MyBinaryTree.Node root, MyBinaryTree.Node input1, MyBinaryTree.Node input2) {
        if (root == null || input1 == null || input2 == null) {
            System.out.print("One of the given nodes does not exist in tree or tree does not exist at all!!");
            return null;
        }
        int difference = depth(input1) - depth(input2);
        MyBinaryTree.Node leveledNode = difference > 0 ? goUpBy(input1, Math.abs(difference)) : goUpBy(input1, Math.abs(difference));
        MyBinaryTree.Node onLevelNode = difference > 0 ? input2 : input1;
        while (leveledNode.parent != onLevelNode.parent) {
            leveledNode = leveledNode.parent;
            onLevelNode = onLevelNode.parent;
        }

        return onLevelNode.parent;

    }

    private MyBinaryTree.Node goUpBy(MyBinaryTree.Node focusNode, int difference) {
        while (difference > 0) {
            focusNode = focusNode.parent;
            difference--;
        }
        return focusNode;
    }

    private int depth(MyBinaryTree.Node focusNode) {
        int depth = 0;
        while (focusNode != null) {
            focusNode = focusNode.parent;
            depth++;
        }
        return depth;
    }
}
