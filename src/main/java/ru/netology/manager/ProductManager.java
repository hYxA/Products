package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.TShirt;
import ru.netology.repository.ProductRepository;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductManager {
    private ProductRepository repository = new ProductRepository();
    private Product[] items = new Product[0];

    public ProductManager(ProductRepository repository) {
    }

    public Product[] getItems() {
        items = repository.findAll();
        return items;
    }

    public void addProduct(Product item) {
        repository.save(item);
    }

    private Product[] actionSearchBy(Product product, String text) {
        Product[] result = new Product[0];
        Product[] tmp = new Product[result.length + 1];
        // используйте System.arraycopy, чтобы скопировать всё из result в tmp
        tmp[tmp.length - 1] = product;
        result = tmp;
        return result;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];

        for (Product product : repository.findAll()) {
            if (product instanceof Book) {
                if (matchesBook(product, text)) {
                    result = actionSearchBy(product, text);
                }
            }
            if (product instanceof Smartphone) {
                if (matchesSmartphone(product, text)) {
                    result = actionSearchBy(product, text);
                }
            }
            if (product instanceof TShirt) {
                if (matchesTShirt(product, text)) {
                    result = actionSearchBy(product, text);
                }
            }
        }
        return result;
    }

    /**
     * должен для каждого продукта вызывать собственный метод matches,
     * который проверяет, соответствует ли продукт поисковому запросу.
     */

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            return matchesBook(product, search);
        }
        if (product instanceof Smartphone) {
            return matchesSmartphone(product, search);
        }
        if (product instanceof TShirt) {
            return matchesTShirt(product, search);
        }
        return false;
    }

    public boolean matchesBook(Product product, String search) {

        Book book = (Book) product;
        return book.getName().equalsIgnoreCase(search) ||
                book.getAuthor().equalsIgnoreCase(search);
    }

    public boolean matchesSmartphone(Product product, String search) {

        Smartphone Smartphone = (Smartphone) product;
        return Smartphone.getModel().equalsIgnoreCase(search) ||
                Smartphone.getManufacturer().equalsIgnoreCase(search);

    }

    public boolean matchesTShirt(Product product, String search) {

        TShirt tShirt = (TShirt) product;
        return tShirt.getColor().equalsIgnoreCase(search) ||
                tShirt.getSize().equalsIgnoreCase(search);
    }

    public Product findById(int idToFind) {
        Product result = repository.findById(idToFind);
        return result;
    }
}