/**
 * Created by Nikhil on 10/2/16.
 */
public class TreesSuccessor {
    
    public void  inOrderSuccessor(MyBinaryTree.Node focusNode){
        if (focusNode == null) return;
        if(focusNode.rightChild==null){
            leftMostChild(focusNode);
            return;
        }else{
            MyBinaryTree.Node current = focusNode;
            MyBinaryTree.Node parent = focusNode.parent;
            while(parent.leftChild!=current && parent!=null){
                current = parent;
                parent = parent.parent;
            }
            System.out.println("In order successor is " + parent.nodeValue ) ;
        }



    }

    private void leftMostChild(MyBinaryTree.Node focusNode){
        while(focusNode!=null){
            focusNode = focusNode.leftChild;
        }
        System.out.println("In order successor is " + focusNode.nodeValue);
    }
}
