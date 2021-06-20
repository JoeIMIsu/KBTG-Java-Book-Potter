import java.util.List;

public class BookShelf {
    private final BookRepository repository;

    public BookShelf(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> display() {
        return repository.findAll();
    }
}
