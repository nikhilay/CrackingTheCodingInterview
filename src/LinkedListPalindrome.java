/**
 * Created by Nikhil on 9/15/16.
 */
public class LinkedListPalindrome {

    public boolean isPalindrome(Link node) {
        Link reverseList = reverseLinkList(node);
        return isEqual(node, reverseList);
    }

    public Link reverseLinkList(Link node) {
        //Empty Linked List
        if (node == null) {
            return null;
        }
        Link head = node;
        while (node != null) {
            node.next = head;
            head = node;
            node = node.next;
        }
        return head;
    }

    public boolean isEqual(Link firstList, Link secondList) {
        while (firstList != null && secondList != null) {
            if (firstList.bookName == secondList.bookName) {
                return false;
            }
            firstList = firstList.next;
            secondList = secondList.next;
        }
        return true;
    }
}
