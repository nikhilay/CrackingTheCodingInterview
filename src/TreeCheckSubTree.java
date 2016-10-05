/**
 * Created by Nikhil on 10/5/16.
 */
public class TreeCheckSubTree {
    StringBuilder st1 = new StringBuilder();
    StringBuilder st2 = new StringBuilder();


    public static void main(String[] args) {
        TreeCheckSubTree obj = new TreeCheckSubTree();
        MyBinaryTree tree1 = new MyBinaryTree();
        tree1.addNode(4);
        tree1.addNode(3);
        tree1.addNode(6);
        tree1.addNode(5);
        tree1.addNode(8);
        tree1.addNode(2);
        tree1.addNode(1);
        MyBinaryTree tree2 = new MyBinaryTree();
        tree2.addNode(6);
        tree2.addNode(5);
        tree2.addNode(8);
        obj.checkSubTree(tree1.root, tree2.root);
        System.out.print(obj.containsTree(tree1.root, tree2.root));
    }

    //With MEMORY
    public void checkSubTree(MyBinaryTree.Node tree1, MyBinaryTree.Node tree2) {

        if (tree1 == null && tree2 == null) {
            System.out.print("Both trees are empty!!");
            return;
        } else if (tree2 == null) {
            System.out.print("Yes, Tree 2 is subtree of Tree 1");
            return;
        } else if (tree1 == null) {
            System.out.println("Tree 1 is empty");
        } else {
            preOrderTraversal(tree1, st1);
            preOrderTraversal(tree2, st2);
            System.out.println(" Pre order Traversal of tree 1 is " + st1);
            System.out.println(" Pre order Traversal of tree 2 is " + st2);
            System.out.println(st1.toString().contains(st2.toString()));
        }
    }

    private void preOrderTraversal(MyBinaryTree.Node focusNode, StringBuilder st) {
        if (focusNode == null) {
            st.append("X");
            return;
        }
        st.append(String.valueOf(focusNode.nodeValue));
        preOrderTraversal(focusNode.leftChild, st);
        preOrderTraversal(focusNode.rightChild, st);

    }
    //WITH LESS MEMORY

    public boolean containsTree(MyBinaryTree.Node tree1, MyBinaryTree.Node tree2) {
        if (tree2 == null) return true;
        return subtree(tree1, tree2);

    }

    private boolean subtree(MyBinaryTree.Node tree1, MyBinaryTree.Node tree2) {
        if (tree1 == null) {
            return false;
        } else if (tree1.nodeValue == tree2.nodeValue && matchTree(tree1, tree2)) {
            return true;
        }
        return subtree(tree1.leftChild, tree2) || subtree(tree1.rightChild, tree2);
    }

    private boolean matchTree(MyBinaryTree.Node tree1, MyBinaryTree.Node tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        } else if (tree1 == null || tree2 == null) {
            return false;
        } else if (tree1.nodeValue != tree2.nodeValue) {
            return false;

        } else {
            return matchTree(tree1.leftChild, tree2.leftChild) && matchTree(tree1.rightChild, tree2.rightChild);
        }
    }
}

