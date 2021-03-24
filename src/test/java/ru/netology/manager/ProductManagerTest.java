package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    
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
}