import java.util.List;

public class BookRepository {
    private final Stock stock;

    public BookRepository(Stock stock) {
        this.stock = stock;
    }

    public int count(String s) {
        List<Book> books = stock.getBooks();
        return books.stream().filter(book -> book.getTitle().equals(s)).findFirst().map(Book::getQuantity).orElse(0);
    }

    public List<Book> findAll() {
        return this.stock.getBooks();
    }
}
