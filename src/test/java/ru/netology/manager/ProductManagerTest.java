package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductManager manager = new ProductManager();

    private Product something =
            new Product(01, "something", 0);

    private Product discount =
            new Product(00, "discount", 50);

    private Book ancient =
            new Book(02, "ancient", 500,
                    "Tarmashev", 312, 2018);

    private Book stalker =
            new Book(05, "sandWatch", 500,
                    "Nedorub", 312, 2009);

    private Smartphone samsungA40 =
            new Smartphone(03, "samsungA40", 15990,
                    "A40", "samsung");

    private Smartphone samsungA21s =
            new Smartphone(04, "samsungA21s", 16990,
                    "A21s", "samsung");

    private TShirt polo =
            new TShirt(06, "lacoste", 7000,
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
        };
        Product[] actual = manager.getItems();

        assertArrayEquals(expected, actual);
    }

}