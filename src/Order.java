import java.util.ArrayList;
import java.util.List;

public class Order {
    private long orderId;
    List<Book> books;

    public Order() {
        this.books = new ArrayList<>();
    }
    public void addMeal(Book book){
        books.add(book);
    }




    public long getOrderId() {
        return orderId;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", books=" + books +
                '}';
    }
}
