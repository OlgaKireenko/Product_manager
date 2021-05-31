package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerSearchByTest {


    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);


    Product First1 = new Book(1, 100, "Book1", "111");
    Product First2 = new Book(2, 100, "Book22", "222");
    Book First3 = new Book(3, 100, "Book33", "333");
    Book First4 = new Book(4, 100, "Book44", "444");
    Book First5 = new Book(5, 100, "Book55", "111");
    Product First11 = new Smartphone(11, 150, "iPhone1", "Apple");
    Product First22 = new Smartphone(22, 150, "iPhone2", "Apple");
    Smartphone First33 = new Smartphone(33, 150, "iPhone3", "Apple");
    Smartphone First44 = new Smartphone(44, 150, "iPhone4", "Apple");
    Smartphone First55 = new Smartphone(55, 150, "iPhone5", "Apple");


    @BeforeEach
    public void setUp() {
        manager.add(First1);
        manager.add(First2);
        manager.add(First3);
        manager.add(First4);
        manager.add(First5);
        manager.add(First11);
        manager.add(First22);
        manager.add(First33);
        manager.add(First44);
        manager.add(First55);


    }

    @Test
    public void ShouldSearchBy() {

        Product[] actual = manager.searchBy("Book1");
        Product[] expected = new Product[]{First1};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void ShouldSearchBy2() {


        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{First11, First22, First33, First44, First55};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void ShouldSearchBy3() {


        Product[] actual = manager.searchBy("222");
        Product[] expected = new Product[]{First2};
        assertArrayEquals(actual, expected);

    }

    @Test
    public void ShouldSearchBy4() {


        Product[] actual = manager.searchBy("iPhone3");
        Product[] expected = new Product[]{First33};
        assertArrayEquals(actual, expected);

    }


}
