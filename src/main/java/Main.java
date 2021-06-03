import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class Main {
    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();
        Product First1 = new Book(1, 100, "Book1", "111");
        Product First2 = new Book(2, 100, "Book22", "222");
        Book First3 = new Book(3, 100, "Book33", "333");
        Book First4 = new Book(4, 100, "Book44", "444");
        repository.save(First1);
        repository.save(First2);
        repository.save(First3);
        repository.save(First4);
        repository.removeById(-20);
        //repository.removeById(1);
    }
}
