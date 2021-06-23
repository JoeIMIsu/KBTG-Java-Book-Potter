import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final Customer customer;
    private List<Book> books;
    private final Calculator calculator;

    public Basket(Customer customer, Calculator calculator) {
        this.customer = customer;
        this.books = new ArrayList<>();
        this.calculator = calculator;
    }

    //region Get Set

    public Customer getCustomer() {
        return customer;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    //endregion

    //region Functions
    public void addBook(Book book) {
        books.add(book);
        for (int i = 0; i < book.getQuantity(); i++) {
            calculator.addBookId(book.getId());
        }
        calculator.calculatePrice();
    }

    public boolean removeBook(Book removeBook) {
        boolean result = false;

        for (Book book : this.books) {
            if (book.getId() == removeBook.getId()) {
                this.books.remove(book);
                for (int i = 0; i < removeBook.getQuantity(); i++) {
                    this.calculator.removeBookId(removeBook.getId());
                }
                result = true;
                break;
            }
        }

        return result;
    }

    public Book getBook(String title) {
        return this.books.stream().filter(book -> book.getTitle().equals(title)).findFirst().orElse(null);
    }

    public int displayCount() {
        return this.books.size();
    }

    public void display() {
        System.out.println(">> Display Basket");
        for (Book book : this.books) {
            System.out.println("- Basket: " + book.toString());
        }
    }

    public double displayDiscount() {
        return calculator.getDiscount();
    }

    public double displayTotalPrice() {
        return calculator.getTotalPrice();
    }

    public double displaySubTotal() {
        return calculator.getSubTotal();
    }
    //endregion
}
