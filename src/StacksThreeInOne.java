/**
 * Created by Nikhil on 9/18/16.
 */
public class StacksThreeInOne {

    private int stacksize;
    private int numberOfStacks = 3;
    private int[] sizes;
    private int[] values;

    StacksThreeInOne(int stacksize) {
        this.stacksize = stacksize;
        sizes = new int[numberOfStacks];
       // Arrays.fill(sizes,0);
        values = new int[numberOfStacks * stacksize];
    }

    public static void main(String[] args){
        StacksThreeInOne obj = new StacksThreeInOne(2);
        obj.push(1,1);
        obj.push(1,2);
        obj.push(2,3);
        obj.push(2,4);
        obj.peek(2);
        obj.pop(2);
        obj.pop(2);
        obj.pop(2);

    }
    public void push(int stacknum, int data) {
        if (isFull(stacknum)) {
            System.out.println(" Sorry, stack is full. Please try other stacks");
        } else {
            sizes[stacknum - 1] = sizes[stacknum - 1] + 1;
            values[indexOfStackTop(stacknum)] = data;
            System.out.println(data + " has been pushed in stack "+ stacknum);

        }
    }

    public boolean isFull(int stacknum) {
        return sizes[stacknum - 1] == stacksize;

    }

    private int indexOfStackTop(int stacknum) {
        int offset = (stacknum - 1) * stacksize;
        int current = sizes[stacknum - 1];
        return offset + current;

    }

    public void pop(int stacknum) {
        if (isEmpty(stacknum)) {
            System.out.println(" Sorry, stack " + stacknum + " is empty");

        } else {
            int value = values[indexOfStackTop(stacknum)];
            values[indexOfStackTop(stacknum)] = 0;
            sizes[stacknum - 1] = sizes[stacknum - 1] - 1;
            System.out.println(value + " is the top element which has been popped out of Stack "+stacknum);
        }
    }

    public void peek(int stacknum) {
        if (isEmpty(stacknum)) {
            System.out.println(" Sorry, stack " + stacknum + " is empty");

        } else {
            int value = values[indexOfStackTop(stacknum)];
            System.out.println(" The element is " + value);

        }
    }

    public boolean isEmpty(int stacknum) {
        return sizes[stacknum - 1] == 0;
    }
}
