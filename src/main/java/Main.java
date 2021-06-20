import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Mojoe");
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
        List<Book> bookList =  bookShelf.display();
        for (Book book : bookList) {
            System.out.println(">> Display " + book.toString());
        }



    }
}
