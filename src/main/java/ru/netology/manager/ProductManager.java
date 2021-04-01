package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.TShirt;
import ru.netology.repository.ProductRepository;
import static java.lang.System.arraycopy;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductManager {
    private ProductRepository repository = new ProductRepository();
    private Product[] items = new Product[0];

    public Product[] getItems() {
        items = repository.findAll();
        return items;
    }

    public void addProduct(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String text) {
        Product[] massiveResult = new Product[0];

        for (Product item : repository.findAll()) {
            if (matches(item, text)) {
                Product[] tmp = new Product[massiveResult.length+1];
                arraycopy(items, 0, tmp, 0, items.length);
                tmp[tmp.length - 1] = item;
                massiveResult = tmp;
                
            }
        }
        return massiveResult;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().equalsIgnoreCase(search)) {
            return true;
        }
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
        }

        if (product instanceof Smartphone) {
            Smartphone Smartphone = (Smartphone) product;
            if (Smartphone.getModel().equalsIgnoreCase(search)) {
                return true;
            }
            if (Smartphone.getManufacturer().equalsIgnoreCase(search)) {
                return true;
            }
        }

        if (product instanceof TShirt) {
            TShirt tShirt = (TShirt) product;
            if (tShirt.getSize().equalsIgnoreCase(search)) {
                return true;
            }
            if (tShirt.getColor().equalsIgnoreCase(search)) {
                return true;
            }
        }
        return false;
    }

    public Product findById(int idToFind) {
        Product result = repository.findById(idToFind);

        return result;
    }
}