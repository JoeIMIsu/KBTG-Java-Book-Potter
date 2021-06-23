import java.util.List;

public class BookRepository {
    private final Stock stock;

    public BookRepository(Stock stock) {
        this.stock = stock;
    }

    public List<Book> findAll() {
        return this.stock.getBooks();
    }

    public Book findById(int id) {
        return this.stock.getBooks().stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    public int countByTitle(String title) {
        List<Book> books = stock.getBooks();
        return books.stream().filter(book -> book.getTitle().equals(title)).findFirst().map(Book::getQuantity).orElse(0);
    }

    public int decrement(Book book, int amount) {
        int currentAmount = book.getQuantity();
        book.setQuantity(currentAmount - amount);
        return book.getQuantity();
    }

    public int increment(Book book, int amount) {
        int currentAmount = book.getQuantity();
        book.setQuantity(currentAmount + amount);
        return book.getQuantity();
    }
}
