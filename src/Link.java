/**
 * Created by Nikhil on 9/13/16.
 */
public class Link {

    public String bookName;
    public int copiesSold;
    public Link next;

    public Link(String bookName, int copiesSold) {
        this.bookName = bookName;
        this.copiesSold = copiesSold;
    }

    public void display() {
        System.out.println(" Book Name is " + bookName + " and " + copiesSold + " million copies has been sold");
    }


}
