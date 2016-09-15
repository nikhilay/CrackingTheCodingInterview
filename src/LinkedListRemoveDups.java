import java.util.HashMap;

/**
 * Created by Nikhil on 9/13/16.
 */
public class LinkedListRemoveDups {

    public void removeDups(Link node) {
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();
        Link previousNode = null;
        while (node != null) {
            if (hmap.containsKey(node.bookName)) {
                previousNode.next = node.next;
            }else{
                hmap.put(node.bookName, node.copiesSold);
                previousNode = node;
            }
            node = node.next;
        }
    }
}
