import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Mojoe");
        System.out.println("== Init Book Shop");
        System.out.println(">> Stock");
        Stock stock = new Stock();
        stock.initStock();

        BookRepository repository = new BookRepository(stock);
        System.out.println("count stock Harry 1: " + repository.count("Harry 1"));
        System.out.println("count stock Harry 2: " + repository.count("Harry 2"));
        System.out.println("count stock Harry 3: " + repository.count("Harry 3"));
        System.out.println("count stock Harry 4: " + repository.count("Harry 4"));
        System.out.println("count stock Harry 5: " + repository.count("Harry 5"));

        System.out.println(">> BookShelf");
        BookShelf bookShelf = new BookShelf(repository);
        bookShelf.display();

        System.out.println("== End Init Book Shop");

        System.out.println(">> Init Customer");
        Customer customer = new Customer(1, "Mana");
        System.out.println(">> Init Basket");
        Basket basket = new Basket(customer);

        System.out.println(">> Select Book");
        Book book1 = bookShelf.selectBook(0, 2);
        basket.addBook(book1);

        System.out.println(">> Basket Count: " + basket.displayCount());
        basket.display();

        System.out.println(">> BookShelf");
        bookShelf.display();

        System.out.println(">> Select Book 2");
        Book book2 = bookShelf.selectBook(1, 5);
        basket.addBook(book2);
        System.out.println(">> Basket Count: " + basket.displayCount());
        basket.display();

        System.out.println(">> BookShelf");
        bookShelf.display();

        // deselect
        System.out.println(">> DeSelect Harry 1");
        Book deSelectBook = basket.getBook("Harry 1");
        basket.remove(deSelectBook);
        bookShelf.deSelect(deSelectBook, deSelectBook.getQuantity());

        System.out.println(">> BookShelf");
        bookShelf.display();
    }
}
