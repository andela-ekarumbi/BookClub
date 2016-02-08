package com.andela.bookclub.operations;

import com.andela.bookclub.models.Book;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryCatalogueTest {

    // Private variables to use during testing

    private LibraryCatalogue catalogue1;

    private LibraryCatalogue catalogue2;

    private LibraryCatalogue catalogue3;

    private LibraryCatalogue catalogue4;

    private Book testBook1;

    private Book testBook2;

    private Book testBook3;

    private String testIsbn1;

    // Utility methods

    private String generateId() {
        double randomId = Math.random() * 10000;

        return Double.toString(randomId);
    }

    // Test methods

    @Before
    public  void beforeTestAddNewBook() {
        catalogue1 = new LibraryCatalogue();
        testBook1 = new Book();
        testBook1.setId(generateId());
    }

    @Test
    public void testAddNewBook() throws Exception {
        assertTrue(catalogue1.addNewBook(testBook1));
    }

    @Test
    public void testGetBookByIsbn() throws Exception {

    }

    @Before
    public void beforeTestUpdateBookDetails() {
        testBook2 = new Book();
        testIsbn1 = generateId();
        testBook2.setIsbn(testIsbn1);
        testBook2.setSynopsis("Lorem ipsum dolor sit amet");
        testBook2.setTitle("Lorem Ipsum");
        testBook2.setAuthorName("Unknown Latin Guy");

    }

    @Test
    public void testUpdateBookDetails() throws Exception {

    }

    @Test
    public void testDeleteBook() throws Exception {

    }
}