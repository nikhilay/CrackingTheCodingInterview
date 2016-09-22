import java.util.*;

/**
 * Created by Nikhil on 9/18/16.
 */
public class StacksAndQueueStackofPlates<T> {
    ArrayList<Stack> stacks = new ArrayList<Stack>();
    public static final int FIRST_STACK_INDEX = 0;
    public static final int STACK_SIZE = 3;

    public static void main(String[] args) {
        StacksAndQueueStackofPlates stackOfPlates = new StacksAndQueueStackofPlates();
        stackOfPlates.push(1);
        stackOfPlates.push("nikhil");
        //stackOfPlates.push(3);
        //stackOfPlates.push(4);
        stackOfPlates.pop();
        stackOfPlates.pop();
        stackOfPlates.pop();
        LinkedList input =new LinkedList();
        input.removeFirst();


    }


    public void push(T data) {
        if (stacks.isEmpty()) {
            Stack currentStack = new Stack();
            currentStack.push(data);
            stacks.add(FIRST_STACK_INDEX, currentStack);
            System.out.println(data + " has been inserted in " + FIRST_STACK_INDEX + " stack");
        } else {
            for (int i = 0; i < stacks.size(); i++) {
                if (stacks.get(i) != null && stacks.get(i).size() < STACK_SIZE) {
                    stacks.get(i).push(data);
                    System.out.println(data + " has been inserted in " + i + " stack");
                    return;

                } else {
                    Stack newStack = new Stack();
                    newStack.push(data);
                    System.out.println(data + " has been inserted in " + (i + 1) + " stack");
                    stacks.add(i + 1, newStack);
                    return;
                }

            }
        }

    }

    public void pop() {
        if (stacks.isEmpty() || stacks.get(FIRST_STACK_INDEX).size() == 0) {
            System.out.println(" Set of Stack is empty!!");
        } else {
            /*
            ListIterator it = stacks.listIterator();
            while (it.hasPrevious()) {
                Stack temp = (Stack) it.previous();
                System.out.println(" The popped up element is " + temp.pop());
                return;
            }
            */

            for (int i = stacks.size() - 1; i >= 0; i--) {
                System.out.println(" The popped up element is " + stacks.get(i).pop());
                return;
            }
        }

    }
}










