package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

class BookTest {
    @Test
    void test() {
        Book book = new Book();
        book.setAuthor("Я");
        book.setName("мфяк");

        System.out.println("Hi!");
    }

    @Test
    void shouldCastFromBaseClass() {
        Product product = new Book();

        if (product instanceof Book) {
            Book book = (Book) product;

        }
    }

    @Test
    void shouldNotCastToDifferentClass() {
        Product product = new Book();

        if (product instanceof TShirt) {
            TShirt tShirt = (TShirt) product;
            tShirt.setSize("XXL");
        } else {
            System.out.println("Sorry!");
        }
        System.out.println(product);
    }

}