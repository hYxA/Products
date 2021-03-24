package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book(1, "мфяк", 90000, "я", 1, 2020);
    private TShirt polo = new TShirt("white", "M");

    @Test
    void  shouldSaveOneItem() {
        repository.save(coreJava);
        repository.save(polo);


        Product[] expected = new Product[]{coreJava, polo};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

}