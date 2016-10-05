/**
 * Created by Nikhil on 9/25/16.
 */
public class MyBinaryTree {
    Node root;

    class Node {
        public int nodeValue;

        Node leftChild;
        Node rightChild;
        Node parent;
        int size;

        Node(int nodeValue) {
            this.nodeValue = nodeValue;
        }
    }

    public static void main(String[] args) {
        MyBinaryTree newTree = new MyBinaryTree();
        newTree.addNode(8);
        newTree.addNode(4);
        newTree.addNode(3);
        newTree.addNode(6);
        newTree.addNode(14);
        newTree.addNode(10);
        newTree.addNode(18);

        //newTree.findNode(60);
        //newTree.inOrderTraversal(newTree.root);
        //newTree.preOrderTraversal(newTree.root);
        //newTree.postOrderTraversal(newTree.root);
        newTree.remove(4);
        newTree.inOrderTraversal(newTree.root);


    }

    public void addNode(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            System.out.println(" Root Node value is " + value);
            return;
        } else {
            Node focusNode = root;
            Node parent = focusNode;

            while (true) {
                if (value < focusNode.nodeValue) {
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        System.out.println(" Node has been added as left child with value " + value);
                        return;
                    }

                } else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        System.out.println(" Node has been added as right child with value " + value);
                        return;
                    }
                }
                parent = focusNode;
            }

        }
    }

    public Node findNode(int value) {
        Node focusNode = root;
        if (root == null) {
            return null;
        }
        while (focusNode.nodeValue != value) {
            if (value < focusNode.nodeValue) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null) {
                System.out.println("Node not found");
                return null;
            }
        }
        System.out.println("Node found");
        return focusNode;
    }

    public void inOrderTraversal(Node focusNode) {
        if (focusNode == null) {
            return;
        }
        inOrderTraversal(focusNode.leftChild);
        System.out.print(focusNode.nodeValue + " | ");
        inOrderTraversal(focusNode.rightChild);
    }

    public void preOrderTraversal(Node focusNode) {
        if (focusNode == null) {
            return;
        }
        System.out.print(focusNode.nodeValue + " | ");
        preOrderTraversal(focusNode.leftChild);
        preOrderTraversal(focusNode.rightChild);

    }

    public void postOrderTraversal(Node focusNode) {
        if (focusNode == null) {
            return;
        }
        postOrderTraversal(focusNode.leftChild);
        postOrderTraversal(focusNode.rightChild);
        System.out.print(focusNode.nodeValue + " | ");
    }

    public void remove(int value) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }
        Node focusNode = root;
        boolean isNodeAtLeftChild = true;
        Node parent = focusNode;
        while (focusNode.nodeValue != value) {
            parent = focusNode;
            if (value < focusNode.nodeValue) {
                focusNode = focusNode.leftChild;
                isNodeAtLeftChild = true;
            } else {
                focusNode = focusNode.rightChild;
                isNodeAtLeftChild = false;
            }

            if (focusNode == null) {
                System.out.println("Node not found");
                return;
            }
        }

        if (focusNode.leftChild == null && focusNode.rightChild == null) {
            if (focusNode == root) {
                root = null;
                System.out.println("Node has been removed");
            } else if (isNodeAtLeftChild) {
                parent.leftChild = null;
                System.out.println("Node has been removed");
            } else {
                parent.rightChild = null;
                System.out.println("Node has been removed");
            }
        } else if (focusNode.leftChild == null) {
            if (focusNode == root) {
                root = focusNode.rightChild;
                System.out.println("Node has been removed");
            } else if (isNodeAtLeftChild) {
                parent.leftChild = focusNode.rightChild;
                System.out.println("Node has been removed");
            } else {
                parent.rightChild = focusNode.rightChild;
                System.out.println("Node has been removed");
            }
        } else if (focusNode.rightChild == null) {
            if (focusNode == root) {
                root = focusNode.leftChild;
                System.out.println("Node has been removed");
            } else if (isNodeAtLeftChild) {
                parent.leftChild = focusNode.leftChild;
                System.out.println("Node has been removed");

            } else {
                parent.rightChild = focusNode.leftChild;
                System.out.println("Node has been removed");
            }
        } else {
            Node temp = getReplacedNode(focusNode);
            if (focusNode == root) {
                root = temp;
                System.out.println("Node has been removed");
            } else if (isNodeAtLeftChild) {
                parent.leftChild = temp;
                System.out.println("Node has been removed");

            } else {
                parent.rightChild = temp;
                System.out.println("Node has been removed");
            }

            temp.leftChild = focusNode.leftChild;
        }
    }


    public Node getReplacedNode(Node focusNode) {
        Node replaceParent = focusNode;
        Node replaceChild = focusNode;

        Node temp = focusNode.rightChild;
        while (temp != null) {
            replaceParent = replaceChild;
            replaceChild = temp;
            temp = temp.leftChild;
        }
        if(focusNode.rightChild!=replaceChild){
            replaceParent.leftChild =replaceChild.rightChild;
            replaceChild.rightChild = focusNode.rightChild;
        }
        return replaceChild;
    }
}
