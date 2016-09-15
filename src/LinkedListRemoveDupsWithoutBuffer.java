/**
 * Created by Nikhil on 9/13/16.
 */
public class LinkedListRemoveDupsWithoutBuffer {

    public void removeDupsWithoutBuffer(Link node) {
        Link previousNode = null;
        if (node != null) {
            while (node != null) {
                String bookName = node.bookName;
                Link runner = node.next;
                while (runner != null) {
                    if (runner.bookName.equals(bookName)) {
                        node.next = runner.next;

                    }
                    runner = runner.next;

                }
                node = node.next;
            }
        } else {
            System.out.println(" Linked list is empty");
        }
        System.out.println("Removed Duplicates");
    }
}
