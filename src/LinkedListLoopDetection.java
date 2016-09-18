/**
 * Created by Nikhil on 9/17/16.
 */
public class LinkedListLoopDetection {


    public Link loopStartNode(Link node) {
        if (node == null) {
            return null;
        }
        Link slowPointer = node;
        Link fastPointer = node;
        while (slowPointer != null && fastPointer != null) {
            if (slowPointer == fastPointer) {
                break;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        //No Loop
        if (fastPointer == null) {
            return null;
        }
        slowPointer = node;
        while (slowPointer != fastPointer) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return fastPointer;
    }
}
