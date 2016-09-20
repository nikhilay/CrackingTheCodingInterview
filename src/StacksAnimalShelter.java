import java.util.LinkedList;

/**
 * Created by Nikhil on 9/20/16.
 */
public class StacksAnimalShelter {
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0;

    abstract class Animal {
        private int order;
        String name;

        public Animal(String name) {
            this.name = name;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public boolean isOlderthan(Animal a) {
            return this.order > a.order;
        }
    }

    public void enqueue(Animal animal) {
        animal.setOrder(order);
        order++;
        if (animal instanceof Dog) {
            dogs.push((Dog) animal);
        } else {
            cats.push((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return dequeueCat();
        }
        if (cats.isEmpty()) {
            return dequeueDog();
        }

        Dog d = dogs.peek();
        Cat c = cats.peek();

        if (d.isOlderthan(c)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }

    }

    public Dog dequeueDog() {
        if (dogs.isEmpty()) {
            System.out.println("Dog list is empty");
            return null;
        } else {
            return dogs.poll();
        }
    }

    public Cat dequeueCat() {
        if (cats.isEmpty()) {
            System.out.println("Cat list is empty");
            return null;
        } else {
            return cats.poll();
        }

    }

    class Dog extends Animal {
        public Dog(String n) {
            super(n);
        }
    }

    class Cat extends Animal {
        public Cat(String n) {
            super(n);
        }
    }
}
