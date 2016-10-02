/**
 * Created by Nikhil on 10/1/16.
 */
public class TreesMinimalTree {

    class Node {
        public int nodeValue;

        Node leftChild;
        Node rightChild;

        Node(int nodeValue) {
            this.nodeValue = nodeValue;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreesMinimalTree obj = new TreesMinimalTree();
        obj.createMinimalTree(array);
    }

    public void createMinimalTree(int[] array) {
        Node focusNode = createMinimalTreeRecursive(array, 0, array.length - 1);
        System.out.println("Tree with minimal height has been created");
        inOrderTraversal(focusNode);
    }


    private Node createMinimalTreeRecursive(int[] array, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(array[mid]);
        root.leftChild = createMinimalTreeRecursive(array, start, mid - 1);
        root.rightChild = createMinimalTreeRecursive(array, mid + 1, end);
        return root;
    }

    public void inOrderTraversal(Node focusNode) {
        if (focusNode == null) {
            return;
        }
        inOrderTraversal(focusNode.leftChild);
        System.out.print(focusNode.nodeValue + " | ");
        inOrderTraversal(focusNode.rightChild);
    }
}
