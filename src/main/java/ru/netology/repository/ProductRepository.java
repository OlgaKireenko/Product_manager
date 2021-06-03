package ru.netology.repository;

import ru.netology.NotFoundException;
import ru.netology.domain.Product;

import static java.lang.System.arraycopy;

public class ProductRepository {

    private ProductRepository repository;
    private Product[] items = new Product[0];

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Product[]  removeById(int id) {

        if (findById(id) == null) {
            throw new NotFoundException("Ты просишь удалить элемент с id" +id+",a он не существует");
        }
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return items;
    }
}

