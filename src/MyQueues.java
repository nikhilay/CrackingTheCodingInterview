/**
 * Created by Nikhil on 9/18/16.
 */
public class MyQueues<T> {

    private class QueueNode<T> {
        T data;
        QueueNode next;

        QueueNode(T data) {
            this.data = data;
        }
    }

    QueueNode top;
    QueueNode rear;

    public static void main(String[] args) {
        MyQueues test = new MyQueues();
        test.add("Nikhil");
        test.add(90);
        test.add(2.334);
        test.peek();
        test.remove();
        test.peek();
        System.out.println(test.isEmpty());
    }

    public void add(T data) {
        QueueNode element = new QueueNode(data);
        if (top == null && rear == null) {
            rear = element;
            top = element;

        } else {
            rear.next = element;
            rear = element;
        }
    }

    public void peek() {
        if (top != null) {
            System.out.println(" The first element in Queue is " + top.data);
        } else {
            System.out.println(" Sorry queue is Empty ");
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public T remove() {
        if (isEmpty()) {
            System.out.println(" Sorry queue is Empty ");
            return null;
        } else {
            T nodeData = (T) top.data;
            top = top.next;
            if (top == null) {
                rear = null;
            }
            return nodeData;
        }
    }
}
