/**
 * Created by Nikhil on 9/13/16.
 */
public class LinkList {
    Link firstLink;

    public LinkList() {
        firstLink = null;
    }

    public boolean isEmpty() {

        return (firstLink == null);
    }

    public void insertLink(String bookName, int copiesSold) {
        Link node = new Link(bookName, copiesSold);
        node.next = firstLink;
        firstLink = node;
    }

    public void removeFirst() {
        if (!isEmpty()) {
            firstLink = firstLink.next;
        } else {
            System.out.println(" Linked List is empty");
        }
    }

    public void displayAll() {
        Link temp = firstLink;
        while (temp != null) {
            temp.display();
            temp = temp.next;
        }
    }

    public String bookName(){
        return firstLink.bookName.toString();
    }

    public Link findNode(String bookName) {
        Link temp = firstLink;
        if (!isEmpty()) {
            while (temp != null) {
                if (temp.bookName.equals(bookName)) {
                    System.out.println(" Node found ");
                    return temp;
                } else {
                    temp = temp.next;
                }
            }
            System.out.println(" Node not found ");

        } else {
            System.out.println(" Linked List is empty");
        }
        return null;

    }

    public boolean removeNode(String bookName) {
        Link currentNode = firstLink;
        Link previousNode = null;

        if (!isEmpty()) {
            while (currentNode != null) {
                if (currentNode.bookName.equals(bookName)) {
                    System.out.println(" Found a match and removed the link");
                    if (currentNode.next == null) {
                        previousNode.next = currentNode.next;
                    } else {
                        previousNode.next = currentNode.next;
                    }
                    return true;
                } else {
                    previousNode = currentNode;
                    currentNode = currentNode.next;
                }
            }

        } else {
            System.out.println(" Linked List is empty");
        }
        return false;

    }
}
