import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Nikhil on 10/13/16.
 */
public class DPRobotInGrid {
    class Point {
        int row;
        int column;

        Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
    D
    public ArrayList<Point> findPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<Point>();
        HashSet<Point> failurePoints = new HashSet<Point>();
        if (findPath(maze, path, maze.length - 1, maze[0].length - 1, failurePoints)) {
            return path;
        }
        return null;
    }

    private boolean findPath(boolean[][] maze, ArrayList<Point> path, int row, int column, HashSet<Point> failurePoints) {
        if (row < 0 || column < 0 || !maze[row][column]) return false;
        if (row == 0 && column == 0) return true;
        Point p = new Point(row, column);
        if (failurePoints.contains(p)) {
            return false;
        }

        if (findPath(maze, path, row - 1, column, failurePoints) || findPath(maze, path, row, column - 1, failurePoints)) {
            path.add(p);
            return true;
        }
        failurePoints.add(p);
        return false;
    }

}
