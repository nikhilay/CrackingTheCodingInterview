/**
 * Created by Nikhil on 9/15/16.
 */
public class LinkedListDeleteMiddleNode {

    public boolean deleteMiddleNode(Link node) {
        //Empty Linked list and last Node
        if (node.next == null || node == null) {
            return false;
        }

        node.bookName = node.next.bookName;
        node.copiesSold = node.next.copiesSold;
        node.next = node.next.next;
        return true;
    }
    
}
