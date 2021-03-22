package ru.netology.manager;

import ru.netology.domain.Product;

import static java.lang.System.arraycopy;

public class ProductManager {

    private Product[] items = new Product[0];
    public void addFilm(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        // копируем поэлементно
        arraycopy(items, 0, tmp, 0, length - 1);

        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }
}
