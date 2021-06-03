package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.NotFoundException;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryExceptionTest {
    ProductRepository repository = new ProductRepository();
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
        repository.save(First1);
        repository.save(First2);
        repository.save(First3);
        repository.save(First4);
        //repository.save(First5);
        //repository.save(First11);
        //repository.save(First22);
        //repository.save(First33);
        //repository.save(First44);
        //repository.save(First55);
    }

    @Test
    public void shouldGiveException() {
        assertThrows(NotFoundException.class, () -> repository.removeById(100));


        //assertArrayEquals(actual; expected);


    }

    @Test
    public void shouldNotGiveException() {

        Product[] actual = repository.removeById(1);
        Product[] expected = new Product[]{First2, First3,First4};

        assertArrayEquals(actual, expected);


    }
}