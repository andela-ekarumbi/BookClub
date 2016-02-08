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
    public void testUpdateBookDetails() throws Exception {

    }

    @Test
    public void testDeleteBook() throws Exception {

    }

    @Test
    public void testGetBookByIsbn() throws Exception {

    }
}