import java.util.HashSet;

/**
 * Created by Nikhil on 10/13/16.
 */
public class DPPaintFill {

    class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public boolean fillThePaint(char[][] screen, char newColor, Point p) {
        if (screen.length == 0 && screen[0].length == 0) return false;
        if (newColor != 'R' || newColor != 'G' || newColor != 'B' || newColor != 'Y') {
            System.out.println("Color not found!!");
            return false;
        }
        HashSet<Point> completedPoints = new HashSet<>();
        return fillThePaint(screen, newColor, p, completedPoints);
    }

    private boolean fillThePaint(char[][] screen, char newColor, Point p, HashSet<Point> completedPoints) {
        if (p.row < 0 || p.col < 0 || p.row >= screen.length || p.col >= screen[0].length) return false;
        if (completedPoints.contains(p)) return true;
        boolean result;
        if (screen[p.row][p.col] == newColor) {
            return true;
        } else {
            int row = p.row;
            int col = p.col;
            Point upperPoint = new Point(row - 1, col);
            Point lowerPoint = new Point(row + 1, col);
            Point leftPoint = new Point(row, col - 1);
            Point rightPoint = new Point(row, col + 1);
            result = fillThePaint(screen, newColor, upperPoint, completedPoints) ||
                    fillThePaint(screen, newColor, lowerPoint, completedPoints) ||
                    fillThePaint(screen, newColor, leftPoint, completedPoints) ||
                    fillThePaint(screen, newColor, rightPoint, completedPoints);
            if (result) completedPoints.add(p);
        }

        return result;


    }
}
