/**
 * Created by Nikhil on 10/3/16.
 */
public class TreesFirstCommonAncestor {

    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        tree.addNode(30);
        tree.addNode(20);
        tree.addNode(60);
        tree.addNode(40);
        tree.addNode(70);
        tree.addNode(10);
        tree.addNode(25);
        tree.addNode(5);
        tree.addNode(15);
        TreesFirstCommonAncestor obj = new TreesFirstCommonAncestor();
        MyBinaryTree.Node result = obj.getAncestor(tree.root, 70, 25);
        System.out.print("Ancestor is " + result.nodeValue);

    }


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

    //Second Solution with better worst time complexity

    public MyBinaryTree.Node secondSolutionFirstCommonAncestor(MyBinaryTree.Node root, MyBinaryTree.Node input1, MyBinaryTree.Node input2) {
        if (!covers(root, input1) || !covers(root, input2)) {
            return null;
        } else if (covers(input1, input2)) {
            return input1;
        } else if (covers(input2, input1)) {
            return input2;
        }

        MyBinaryTree.Node sibling = getSibling(input1);
        MyBinaryTree.Node parent = input1.parent;

        while (!covers(sibling, input2)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;

    }

    private MyBinaryTree.Node getSibling(MyBinaryTree.Node focusNode) {
        if (focusNode == null || focusNode.parent == null) {
            return null;
        }
        MyBinaryTree.Node parent = focusNode.parent;
        return parent.leftChild == focusNode ? parent.rightChild : parent.leftChild;
    }


    private boolean covers(MyBinaryTree.Node root, MyBinaryTree.Node focusNode) {
        if (root == null) return false;
        if (focusNode.nodeValue == root.nodeValue) return true;

        return covers(root.leftChild, focusNode) || covers(root.rightChild, focusNode);
    }

    //Solution without links to parents
    private boolean covers(MyBinaryTree.Node root, int focusNodeValue) {
        if (root == null) return false;
        if (focusNodeValue == root.nodeValue) return true;

        return covers(root.leftChild, focusNodeValue) || covers(root.rightChild, focusNodeValue);
    }

    public MyBinaryTree.Node getAncestor(MyBinaryTree.Node root, int input1, int input2) {
        boolean isInput1onLeft = covers(root.leftChild, input1);
        boolean isInput2onLeft = covers(root.leftChild, input2);

        if (isInput1onLeft != isInput2onLeft) {
            return root;
        }

        MyBinaryTree.Node rootChild = isInput1onLeft ? root.leftChild : root.rightChild;
        return getAncestor(rootChild, input1, input2);

    }
}
