/**
 * Created by Nikhil on 9/14/16.
 */
public class LinkedListKthToLastElement {
    public int kthToLastElement(Link node, int k) {
        if (node == null) {
            return 0;
        } else {
            int index = kthToLastElement(node.next, k) + 1;
            if (index == k) {
                System.out.println(" Kth element is " + node.bookName + " and " + node.copiesSold + " million copies has been sold");
            }
            return index;

        }
    }

    public Link iterativeKthToLastElement(Link node, int k) {
        Link p1 = node;
        Link p2 = node;

        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                System.out.println(" Index out of bound");
            }
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        System.out.println(" Kth element is " + p2.bookName + " and " + p2.copiesSold + " million copies has been sold");
        return p2;
    }
}
