import java.io.*;

import static javafx.scene.input.KeyCode.F;

/**
 * Created by Nikhil on 10/12/16.
 */
public class SortingMissingInt {

    public void findMissingInt() throws IOException {
        byte[] bitfield = new byte[(int) ((Integer.MAX_VALUE+ 1) / 8) ];
        File f = new File("test1.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line = null;
        while ((line = br.readLine()) != null) {
            int n = Integer.valueOf(line);
            bitfield[n / 8] |= 1 << (n % 8);
        }
        br.close();

        for (int i = 0; i < bitfield.length; i++) {
            for (int j = 0; j < 8; j++) {
                if ((bitfield[i] & 1 << j) == 0) {
                    System.out.println("Number is " + i * 8 + j);
                    return;
                }
            }
        }
    }
}
