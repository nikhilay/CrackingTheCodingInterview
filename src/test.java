import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
 * Created by Nikhil on 9/29/16.
 */
public class test {

    public static void main(String[] args) throws FileNotFoundException {

        float x = 22f;
        float y = 7f;
        System.out.println((x / y) * 100 > 60f);
        //String s = "ABCD";
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i+1; j < s.length(); j++) {
//                System.out.println(s.substring(i, j )+" "+ s.substring(j));
//            }
//        }
        HashSet<String> str = new HashSet<>();
        str.add("a,b,c,d");
//        str.add("b");
//        str.add("c");
//        str.add("d");
        for (String s : str) {
            String[] temp = s.split(",");
            int i =0;
                for (int j = i + 1; j < temp.length; j++) {
                    HashSet<String> key = new HashSet<>();
                    HashSet<String> value = new HashSet<String>();
                    for (int k = i; k < j; k++) {
                        System.out.print("key is " + temp[k] + " ");
                    }
                    System.out.println("\n");
                    //System.out.print("value ");
                    for (int k = j; k < temp.length; k++) {
                        System.out.print("value "+ temp[k] + " ");
                    }



            }

            ;


//        HashSet<Integer> hset = new HashSet<>();
//        HashSet<Integer> hsetnew = new HashSet<>();
//        hset.add(1);
//        hset.add(2);
//        hsetnew.add(2);
//        hsetnew.add(3);
//        hset.addAll(hsetnew);
        }
//        StringBuilder sb = new StringBuilder();
//        String file = "friendship.txt";
//        Scanner sc = new Scanner(new File(file));
//        while (sc.hasNextLine()) {
//            sb.append(sc.nextLine().toString() + ", ");
//        }
//        System.out.print(sb.toString());
//    }


    }
}

