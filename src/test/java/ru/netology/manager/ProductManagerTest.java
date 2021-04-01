package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.TShirt;
import ru.netology.repository.ProductRepository;


import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
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

    @BeforeEach
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
        manager.addProduct(something);
        Product[] actual = manager.getItems();
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
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        int idToFind = 4;
        Product actual = manager.findById(idToFind);
        Smartphone expected = samsungA21s;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesProduct() {
        Product product = discount;
        boolean expected = manager.matches(product, "discount");

        assertTrue(expected);
    }

    @Test
    public void shouldMatchesBookAuthor() {
        Book book = stalker;
        boolean expected = manager.matches(book, "Nedorub");

        assertTrue(expected);
    }

    @Test
    public void shouldMatchesBookName() {
        Book book = ancient;
        boolean expected = manager.matches(book, "ancient");

        assertTrue(expected);
    }

    @Test
    public void shouldMatchesTShirtSize() {
        TShirt tShirt = polo;
        boolean expected = manager.matches(tShirt, "xs");

        assertTrue(expected);
    }

    @Test
    public void shouldMatchesTShirtColor() {
        TShirt tShirt = polo;
        boolean expected = manager.matches(tShirt, "red");

        assertTrue(expected);
    }

    @Test
    public void shouldNotMatches() {
        TShirt tShirt = polo;
        boolean expected = manager.matches(tShirt, "blue");

        assertFalse(expected);
    }

    @Test
    public void shouldMatchesSmartphoneModel() {
        Smartphone smartphone = samsungA40;
        boolean expected = manager.matches(smartphone, "a40");

        assertTrue(expected);
    }

    @Test
    public void shouldMatchesSmartphoneManufacturer() {
        Smartphone smartphone = samsungA40;
        boolean expected = manager.matches(smartphone, "samsung");

        assertTrue(expected);
    }

    @Test
    public void shouldSearchByText() {
        Book[] booooks = new Book[]{
                stalker,
                ancient
        };

        Product[] actual = manager.searchBy("s");
        System.out.println(actual);
        assertArrayEquals(expected, actual);

    }

}