package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductManager manager = new ProductManager();

    private final Product something =
            new Product(1, "something", 0);

    private final Product discount =
            new Product(0, "discount", 50);

    private final Book ancient =
            new Book(2, "ancient", 500,
                    "Tarmashev", 312, 2018);

    private final Book stalker =
            new Book(5, "sandWatch", 500,
                    "Nedorub", 312, 2009);

    private final Smartphone samsungA40 =
            new Smartphone(3, "samsungA40", 15990,
                    "A40", "samsung");

    private final Smartphone samsungA21s =
            new Smartphone(4, "samsungA21s", 16990,
                    "A21s", "samsung");

    private final TShirt polo =
            new TShirt(6, "lacoste", 7000,
                    "red", "XS");

    void prepareManager() {
        manager.addProduct(something);
        manager.addProduct(discount);
        manager.addProduct(ancient);
        manager.addProduct(stalker);
        manager.addProduct(samsungA21s);
        manager.addProduct(samsungA40);
        manager.addProduct(polo);
    }

    @Test
    public void shouldSave() {
        prepareManager();
        manager.addProduct(something);
        Product[] expected = new Product[]{
                something,
                discount,
                ancient,
                stalker,
                samsungA21s,
                samsungA40,
                polo,
                something
        };
        Product[] actual = manager.getItems();

        assertArrayEquals(expected, actual);
    }

}