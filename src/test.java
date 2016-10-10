import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * Created by Nikhil on 9/29/16.
 */
public class test {

    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        String file = "friendship.txt";
        Scanner sc = new Scanner(new File(file));
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine().toString() + ", ");
        }
System.out.print(sb.toString());
    }
}

