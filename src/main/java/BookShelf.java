import java.util.List;

public class BookShelf {
    private final BookRepository repository;

    //region Constructor
    public BookShelf(BookRepository repository) {
        this.repository = repository;
    }
    //endregion

    //region Functions
    public void display() {
        List<Book> bookList = repository.findAll();

        int indexBookShelf = 0;
        for (Book book : bookList) {
            System.out.printf("index[%d]| - %s%n", indexBookShelf++, book.toString());
        }
    }

    public Book selectBook(int index, int amount) {
        Book findBook = repository.findAll().get(index);
        Book bookSelect = new Book();
        bookSelect.setId(findBook.getId());
        bookSelect.setTitle(findBook.getTitle());
        bookSelect.setAuthor(findBook.getAuthor());
        bookSelect.setPrice(findBook.getPrice());
        bookSelect.setQuantity(amount);

        // decrement
//        int remain = decrement(findBook, amount);
        int remain = repository.decrement(findBook, amount);

        return bookSelect;
    }

    public void deSelect(Book book, int amount) {
        Book findBook = repository.findById(book.getId());
        int remain = repository.increment(findBook, amount);
    }
    //endregion
}
