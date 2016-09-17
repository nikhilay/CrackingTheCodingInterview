/**
 * Created by Nikhil on 9/16/16.
 */
public class LinkedListIntersection {

    public Link intersectingNode(Link list1, Link list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        if (result1.node != result2.node) {
            return null;
        }

        Link shorter = result1.size < result2.size ? result1.node : result2.node;
        Link longer = result1.size < result2.size ? result2.node : result1.node;
        int k = Math.abs(result1.size - result2.size);
        while (k > 0 && longer != null) {
            longer = longer.next;
            k--;
        }

        while (longer != null && shorter != null) {
            if (longer == shorter) {
                return longer;
            }
            longer = longer.next;
            shorter = shorter.next;
        }
        return null;
    }

    class Result {
        Link node;
        int size;

        Result(Link node, int size) {
            this.node = node;
            this.size = size;
        }
    }

    Result getTailAndSize(Link node) {
        if (node == null) {
            return null;
        }
        int size = 1;
        while (node.next != null) {
            size++;
            node = node.next;
        }
        Result result = new Result(node, size);
        return result;

    }

}
