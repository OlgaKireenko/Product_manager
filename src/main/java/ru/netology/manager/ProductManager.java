package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private Product[] items = new Product[0];
    private ProductRepository repository;
    private String text;

    //public ProductManager() {    }

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }


    public void add(Product item) {

        repository.save(item);

    }


    public Product[] getAll() {
        Product[] items = repository.findAll();
        Product[] result = new Product[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                // используйте System.arraycopy, чтобы скопировать всё из result в tmp
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String text) {
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (book.getAuthor().contains(text)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (book.getName().contains(text)) {
                return true;
            }
            //return false;
        }
        if (product instanceof Smartphone) { // если в параметре product лежит объект класса Book
            Smartphone smartphone = (Smartphone) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            // проверим есть ли поисковое слово в данных об авторе
            if (smartphone.getProducedBy().contains(text)) {
                return true;
            }
            if (smartphone.getName().contains(text)) {
                return true;
            }
        }


            return false;
        //}


           // return false;
}


}
