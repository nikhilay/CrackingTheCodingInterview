import java.util.Stack;

/**
 * Created by Nikhil on 9/18/16.
 */
public class MyStack<T> {
    private class StackNode<T> {
        private T data;
        StackNode next;

        StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode top;

    public static void main(String[] args) {
        MyStack stacks = new MyStack();
        stacks.push("Nikhil");
        stacks.push(2232);
        stacks.push(34.555);
        stacks.pop();
        stacks.peek();

    }

    public void push(T data) {
        StackNode node = new StackNode(data);
        node.next = top;
        top = node;
    }

    public void peek() {
        if (top == null) {
            System.out.println("Sorry, Stack is empty!!");
        } else {
            System.out.println("The top most element in stack is " + top.data);
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public T pop() {
        if (!isEmpty()) {
            T popNode = (T) top.data;
            top = top.next;
            return popNode;
        }
        return null;
    }

    public void displayAll() {
        MyStack temp = new MyStack();

        while (top != null) {
            T tempData = pop();
            System.out.print(tempData + " |");
            temp.push(tempData);
        }

        while (!temp.isEmpty()) {
            push((T) temp.pop());
        }
    }

}
