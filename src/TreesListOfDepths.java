import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Nikhil on 10/1/16.
 */
public class TreesListOfDepths {

    public static void main(String[] args) {
        TreesListOfDepths obj = new TreesListOfDepths();
        MyBinaryTree tree = new MyBinaryTree();
        tree.addNode(40);
        tree.addNode(30);
        tree.addNode(60);
        tree.addNode(20);
        tree.addNode(35);
        tree.addNode(50);
        tree.addNode(70);
        tree.addNode(10);
        ArrayList<LinkedList<Integer>> result = obj.createListsOfDepth(tree.root);
        obj.printListOfDepths(result);
    }

    public ArrayList<LinkedList<Integer>> createListsOfDepth(MyBinaryTree.Node root) {
        if (root == null) {
            System.out.print("Empty Tree");
            return null;
        }
        ArrayList<LinkedList<Integer>> lists = new ArrayList<LinkedList<Integer>>();
        int treeDepth = 0;
        createListsOfDepth(lists, root, treeDepth);
        return lists;

    }

    private void createListsOfDepth(ArrayList<LinkedList<Integer>> lists,
                                    MyBinaryTree.Node focusNode, int treeDepth
    ) {
        if (focusNode == null) {
            return;
        }
        LinkedList<Integer> list;

        if (lists.size() == treeDepth) {
            list = new LinkedList<Integer>();
            lists.add(list);
        } else {
            list = lists.get(treeDepth);
        }
        list.add(focusNode.nodeValue);
        createListsOfDepth(lists, focusNode.leftChild, treeDepth + 1);
        createListsOfDepth(lists, focusNode.rightChild, treeDepth + 1);

    }

    public void printListOfDepths(ArrayList<LinkedList<Integer>> result) {
        if (result.size() == 0) {
            System.out.println("Please create list of list and then print. Thanks!!");
            return;
        }

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " |");
            }
            System.out.print("\n");
        }

    }
}
