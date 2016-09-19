import java.util.Stack;

/**
 * Created by Nikhil on 9/19/16.
 */
public class StackQueueViaStacks<T> {
    private Stack<T> pushStack;
    private Stack<T> peekPopStack;

    StackQueueViaStacks(){
        pushStack = new Stack<T>();
        peekPopStack = new Stack<T>();
    }

    public static void main(String[] args){
        StackQueueViaStacks ob = new StackQueueViaStacks();
        ob.add("nikhil");
        ob.add(1);
        ob.add("katy perry");
        ob.peek();
        ob.remove();
        ob.peek();
        ob.remove();
        ob.remove();
        ob.remove();
    }

    public void add(T data){
        pushStack.push(data);
        System.out.println(data + " has been added in the queue");
    }

    public void peek(){
        if(pushStack.isEmpty()&& peekPopStack.isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        shiftStacks();
        System.out.println("First element in the queue is " + peekPopStack.peek());
    }

    public void shiftStacks(){
        if(peekPopStack.isEmpty()){
            while(!pushStack.isEmpty()){
                peekPopStack.push(pushStack.pop());
            }
        }
    }

    public void remove(){
        if(pushStack.isEmpty()&& peekPopStack.isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        shiftStacks();
        System.out.println(peekPopStack.pop().toString().toUpperCase() + " is removed from the queue" );
    }
}
