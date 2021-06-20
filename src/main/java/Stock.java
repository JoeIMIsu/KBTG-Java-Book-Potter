import java.util.ArrayList;
import java.util.List;

public class Stock {
    private final List<Book> books;

    public Stock() {
        this.books = new ArrayList<>();
    }

    public void initStock() {
        Book book1 = new Book(1, "Harry 1", "JK Roller Coaster", 8.0, 99);
        books.add(book1);

        Book book2 = new Book(2, "Harry 2", "JK Roller Coaster", 8.0, 99);
        books.add(book2);

        Book book3 = new Book(3, "Harry 3", "JK Roller Coaster", 8.0, 99);
        books.add(book3);

        Book book4 = new Book(4, "Harry 4", "JK Roller Coaster", 8.0, 99);
        books.add(book4);

        Book book5 = new Book(5, "Harry 5", "JK Roller Coaster", 8.0, 99);
        books.add(book5);
    }

    public List<Book> getBooks() {
        return books;
    }
}
