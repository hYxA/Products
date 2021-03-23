package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;
import static java.lang.System.arraycopy;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductManager {
    private ProductRepository repository = new ProductRepository();
    private Product[] items = new Product[0];

    public void addProduct(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] massiveResult = new Product[0];

        for (Product item : items) {
            if (matches(item, text)) {
                int length = massiveResult.length + 1;
                Product[] tmp = new Product[length];
                arraycopy(items, 0, tmp, 0, items.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = item;
                massiveResult = tmp;
            }
        }
        return massiveResult;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
        return false;
    }


}