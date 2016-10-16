import javafx.geometry.Pos;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;

/**
 * Created by Nikhil on 10/16/16.
 */
public class DPNQueenProblem {
    class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
       //new DPNQueenProblem().solveNQueenProblem(8);
        new DPNQueenProblem().noOfWays(4);
    }

    public void solveNQueenProblem(int n) {
        Position[] positions = new Position[n];
        boolean isPlacingPossible = solveNQueenProblem(0, n, positions);
        if (isPlacingPossible) {
            System.out.println("Below are the positions where queens wont attack each other");
            int q = 1;
            for (Position p : positions) {
                System.out.println("Queen - " + q + " " + "(" + p.row + ", " + p.col + " )");
                q++;
            }

        } else {
            System.out.println("We cannot place " + n + " - queen in " + n + " x " + n + " chessboard");
        }


    }

    private boolean solveNQueenProblem(int row, int noOfQueen, Position[] positions) {
        if (row == noOfQueen) return true;
        for (int col = 0; col < noOfQueen; col++) {
            boolean isItSafe = true;
            for (int queen = 0; queen < row; queen++) {
                if (positions[queen].col == col || positions[queen].row == row ||
                        (positions[queen].row - positions[queen].col == row - col) ||
                        (positions[queen].row + positions[queen].col == row + col)) {

                    isItSafe = false;
                    break;
                }
            }
            if (isItSafe) {
                positions[row] = new Position(row, col);
                if (solveNQueenProblem(row + 1, noOfQueen, positions)) {
                    return true;
                }
            }
        }

        return false;
    }
    //To find all possible position to place N-Queen


    public void noOfWays(int n) {
        ArrayList<Position[]> result = new ArrayList<Position[]>();
        Position[] positions = new Position[n];
        findAllNQueenPositions(0, n, positions, result);
        System.out.println("No of possible ways is " + result.size());
    }

    private void findAllNQueenPositions(int row, int noOfQueen, Position[] positions, ArrayList<Position[]> result) {
        if (row == noOfQueen) {
            result.add(positions);
            return;

        }
        for (int col = 0; col < noOfQueen; col++) {
            boolean isItSafe = true;
            for (int queen = 0; queen < row; queen++) {
                if (positions[queen].col == col || positions[queen].row == row ||
                        (positions[queen].row - positions[queen].col == row - col) ||
                        (positions[queen].row + positions[queen].col == row + col)) {

                    isItSafe = false;
                    break;
                }
            }
            if (isItSafe) {
                positions[row] = new Position(row, col);
                findAllNQueenPositions(row + 1, noOfQueen, positions, result);
            }
        }

    }

}
