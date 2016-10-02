import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * Created by Nikhil on 9/29/16.
 */
public class test {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String[] st = sc.nextLine().toString().split("\\s+");
//            if(st.length==1){
//                System.out.println("Please mention both the vertices f");
//                return;
//            }
//            System.out.println(st[0]);
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        System.out.println(ll.poll());
        System.out.println(ll.poll());
        System.out.println(ll.poll());
        System.out.println(ll.poll());


        }
    }

