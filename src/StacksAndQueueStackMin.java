/**
 * Created by Nikhil on 9/18/16.
 */
public class StacksAndQueueStackMin {
    public int min = Integer.MAX_VALUE;

    private class StackNode {
        private int data;
        public int min;
        StackNode next;

        StackNode(int data, int min) {
            this.data = data;
            this.min = min;
        }
    }

    private StackNode top;

    public static void main(String[] args) {
        StacksAndQueueStackMin stacks = new StacksAndQueueStackMin();
        stacks.push(1);
        stacks.peek();
        stacks.push(56);
        stacks.peek();
        stacks.push(5);
        stacks.peek();
        stacks.pop();
    }

    public void push(int data) {
        min = data < min ? data : min;
        StackNode node = new StackNode(data, min);
        node.next = top;
        top = node;
    }

    public void peek() {
        if (top == null) {
            System.out.println("Sorry, Stack is empty!!");
        } else {
            System.out.println("The top most element in stack is " + top.data + " and current minimum is " + top.min);
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void pop() {
        if (!isEmpty()) {
            int popNode = top.data;
            top = top.next;
            System.out.println(popNode + " has been popped.");
        }

    }


}

