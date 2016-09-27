import java.util.ArrayList;

/**
 * Created by Nikhil on 9/27/16.
 */
public class MyHeap {
    private ArrayList<Integer> items;
    private int indexOfInsertion = 0;

    public MyHeap() {
        items = new ArrayList<Integer>();
    }

    public static void main(String[] args) {
        MyHeap obj = new MyHeap();
        obj.insert(58);
        obj.insert(34);
        obj.insert(46);
        obj.insert(17);
        obj.insert(16);
        obj.insert(24);
        obj.insert(23);
        obj.insert(5);
        obj.insert(8);
        obj.displayAll();
        obj.delete();
        obj.displayAll();


    }

    private void siftUp() {
        int indexOfLastElement = items.size() - 1;
        int parent = (int) Math.floor((indexOfLastElement - 1) / 2);

        while (parent >= 0) {
            if (items.get(parent) < items.get(indexOfLastElement)) {
                int temp = items.get(parent);
                items.set(parent, items.get(indexOfLastElement));
                items.set(indexOfLastElement, temp);
            } else {
                break;
            }
            indexOfLastElement = parent;
            parent = (int) Math.floor((indexOfLastElement - 1) / 2);
        }
    }

    public void insert(int value) {
        items.add(value);
        indexOfInsertion++;
        siftUp();
        System.out.println("Successfully, " + value + " element has been inserted in MAX HEAP");
    }

    public void delete() {
        if (items.isEmpty()) {
            System.out.println("Empty MAX HEAP");
        } else if (items.size() == 1) {
            int deletedElement = items.get(0);
            System.out.println("Successfully, " + deletedElement + " has been deleted from MAX HEAP");
        } else {
            siftDown();
        }

    }

    private void siftDown() {
        int deletedElement = items.get(0);
        items.set(0, items.size() - 1);
        System.out.println("Successfully, " + deletedElement + " has been deleted from MAX HEAP");
        items.remove(items.size() - 1);
        int parent = 0;
        int child1 = 2 * parent + 1;

        while (child1 < items.size()) {
            int max = child1;
            int child2 = child1 + 1;

            if (child2 < items.size()) {
                if (items.get(child1).compareTo(items.get(child2)) < 0) {
                    max++;
                }
            }

            if (items.get(parent).compareTo(items.get(max)) < 0) {
                int temp = items.get(parent);
                items.set(parent, items.get(max));
                items.set(max, temp);
                parent = max;
                child1 = 2 * parent + 1;
            } else {
                break;
            }
        }

    }

    public void displayAll() {
        for (int i = 0; i < items.size(); i++) {
            System.out.print(items.get(i) + " |");
        }
        System.out.print("\n");
    }

    public boolean isMaxHeapEmpty() {
        return items.isEmpty();
    }
}
