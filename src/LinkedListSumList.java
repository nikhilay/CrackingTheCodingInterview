/**
 * Created by Nikhil on 9/17/16.
 */
public class LinkedListSumList {

    public Link sumList(Link list1, Link list2, int carry) {
        if (list1 == null && list2 == null && carry == 0) {
            return null;
        }
        int value = carry;
        if (list1 != null) {
            value = value + list1.copiesSold;
        }
        if (list2 != null) {
            value = value + list2.copiesSold;
        }

        Link result = new Link("test", value % 10);

        Link more = sumList(list1.next != null ? list1.next : null, list2.next != null ? list2.next : null, value >= 10 ? 1 : 0);
        result.next = more;
        return result;
    }

    public Link sumListFollowUp(Link list1, Link list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        Link head;
        Link result;
        int carry = 0;
        int list1length = 0;
        int list2length = 0;

        while (list1 != null) {
            list1length++;
            list1 = list1.next;

        }
        while (list2 != null) {
            list2length++;
            list2 = list2.next;

        }
        int difference = Math.abs(list1length - list2length);
        if (list1length < list2length) {
            while (difference > 0) {
                head = new Link("test", 0);
                head.next = list1;
                list1 = head;
                difference--;
            }
        } else {
            while (difference > 0) {
                head = new Link("test", 0);
                head.next = list2;
                list2 = head;
                difference--;
            }


        }
        Result finalResult = forwardNumberRecursion(list1, list2);
        return finalResult.node;
    }

    class Result {
        int carry;
        Link node;

        Result(int carry, Link node) {
            this.carry = carry;
            this.node = node;

        }
    }

    Result forwardNumberRecursion(Link list1, Link list2) {
        if (list1 == null && list2 == null) {
            Result result = new Result(0, null);
            return result;
        }
        Result pointer = forwardNumberRecursion(list1.next, list2.next);
        int carry = pointer.carry + list1.copiesSold + list2.copiesSold;
        pointer.carry = carry / 10;
        pointer.node.copiesSold = carry % 10;
        pointer.node.bookName = "test";
        pointer.node.next = pointer.node;
        return pointer;

    }

}
