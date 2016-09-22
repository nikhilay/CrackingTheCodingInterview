//Problem        : Birthday Cake
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;
import java.util.*;

//Your submission should *ONLY* use the following class name
public class Problem {
    public static void main(String[] args) {
        LinkedList<Integer> input = new LinkedList<Integer>();
        Scanner stdin = new Scanner(System.in);
        while(stdin.hasNextLine()){
           String userInput = stdin.nextLine();
            if(userInput.equals("")){
                break;
            }
            int cakeWeight = Integer.parseInt(userInput);
            input.addLast(cakeWeight);
        }
        stdin.close();
        input.removeFirst();
        maxCake(input);
    }

    public static void maxCake(LinkedList<Integer> input) {
        int tempMax = input.getFirst();
        int allMax = input.getFirst();
        for (int i = 0; i < input.size(); i++) {
            if (i + 1 == input.size()) {
                break;
            }
            if (input.get(i) <= input.get(i + 1)) {
                tempMax = tempMax + input.get(i + 1);
                if (tempMax > allMax) {
                    allMax = tempMax;
                }
            } else {
                tempMax = input.get(i + 1);
            }
        }
        System.out.println(allMax);

    }
}
