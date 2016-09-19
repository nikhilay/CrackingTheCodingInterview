import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Nikhil on 9/19/16.
 */
public class StacksSortStack {

    public Stack<Integer> bufferStack;

    StacksSortStack(){
        bufferStack = new Stack<Integer>();
    }

    public static void main(String[] args){
        Stack<Integer> data = new Stack<Integer>();
        data.push(122);
        data.push(1);
        data.push(35);
        data.push(3);
        data.push(4);
        StacksSortStack sortingObject = new StacksSortStack();
        sortingObject.displayAll(data);
        sortingObject.sort(data);
    }

    public void sort(Stack<Integer> data){
        if(data.isEmpty()){
            System.out.println(" Empty Stack!!!");
            return;
        }

        while(!data.isEmpty()){
            int temp = data.pop();
            while(!bufferStack.isEmpty() && temp< bufferStack.peek()){
                data.push(bufferStack.pop());


            }
            bufferStack.push(temp);

        }

        while(!bufferStack.isEmpty()){
            data.push(bufferStack.pop());
        }

        System.out.println("Stack has been sorted");
        displayAll(data);

    }

    public void displayAll(Stack<Integer> data){
        Iterator iterator = data.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" |");
        }
        System.out.print("\n");
    }
}
