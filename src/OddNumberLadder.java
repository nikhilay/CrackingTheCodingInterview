/**
 * Created by Nikhil on 9/29/16.
 */
public class OddNumberLadder {

    public static void main(String[] args) {
        new OddNumberLadder().generateLadder(10);
        new OddNumberLadder().createLadder(10);
    }

    // Displaying the usage of continue with label statement
    public void generateLadder(int input) {
        outerLabel:
        for (int x = 1; x > 0; x++) {
            innerLabel:
            for (int y = 1; y <= x; y++) {
                if (x > input) {
                    break outerLabel;
                }

                if (x % 2 == 0) {
                    continue outerLabel;
                }

                if (y % 2 == 0) {
                    continue innerLabel;
                }

                System.out.print(y + " ");
            }
            System.out.print("\n");
        }

    }

    //Without usage of continue label statement
    public void createLadder(int input) {

        for (int x = 1; x <= input; x = x + 2) {
            for (int y = 1; y <= x; y = y + 2) {
                System.out.print(y + " ");
            }
            System.out.print("\n");

        }

    }
}
