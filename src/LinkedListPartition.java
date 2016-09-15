/**
 * Created by Nikhil on 9/15/16.
 */
public class LinkedListPartition {

    public boolean partition(Link node, int x) {
        //Empty linked list
        if (node == null) {
            return false;
        }
        Link head = node;
        Link tail = node;

        while (node != null) {

            if (node.copiesSold < x) {
                node.next = head;
                head = node;

            } else {
                tail.next = node;
                tail = node;
            }
            node = node.next;
        }
        tail.next = null;
        return true;
    }
}
