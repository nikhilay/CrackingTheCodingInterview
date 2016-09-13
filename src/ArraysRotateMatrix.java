/**
 * Created by Nikhil on 9/13/16.
 */
public class ArraysRotateMatrix {
    public boolean rotateMatrix(int[][] inputImage) {
        if (inputImage.length == 0 || inputImage.length != inputImage[0].length) {
            return false;
        }
        int n = inputImage.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first ;
                int top = inputImage[first][i];

                //left to top

                inputImage[first][i] = inputImage[last - offset][first];

                //bottom to left

                inputImage[last - offset][first] =  inputImage[last][last - offset];

                //right to left
                inputImage[last][last - offset] = inputImage[i][last];

                //top to right

                inputImage[i][last] = top;

            }

        }
        return true;
    }
}
