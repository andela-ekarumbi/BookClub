package com.andela.bookclub.operations;

import com.andela.bookclub.models.Book;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LibraryCatalogueTest {

    // Private variables to use during testing

    private LibraryCatalogue catalogue1;

    private LibraryCatalogue catalogue2;

    private LibraryCatalogue catalogue3;

    private LibraryCatalogue catalogue4;

    private LibraryCatalogue catalogue5;

    private Book testBook1;

    private Book testBook2;

    private Book testBook3;

    private String testIsbn1;

    private String testIsbn2;

    private String testIsbn3;

    // Utility methods

    private String generateIsbn() {
        double randomId = Math.random() * 10000000;

        return Double.toString(randomId);
    }

    // Test methods

    @Before
    public  void beforeTestAddNewBook() {
        catalogue1 = new LibraryCatalogue();
        testBook1 = new Book();
        testBook1.setIsbn(generateIsbn());
    }

    @Test
    public void testAddNewBook() throws Exception {
        assertTrue(catalogue1.addNewBook(testBook1));
    }

    @Before
    public void beforeTestGetAllBooks() {
        catalogue2 = new LibraryCatalogue();

        // Add five books

        for (int i = 0; i < 5; i++) {
            catalogue2.addNewBook(new Book());
        }

    }

    @Test
    public void testGetAllBooks() {
        List<Book> books = catalogue2.getAllBooks();
        assertNotSame(null, books);
        assertEquals(5, books.size());
    }

    @Before
    public void beforeTestGetBookByIsbn() {
        testBook2 = new Book();
        testIsbn1 = generateIsbn();
        testBook2.setIsbn(testIsbn1);

        catalogue3 = new LibraryCatalogue();
        catalogue3.addNewBook(testBook2);
    }

    @Test
    public void testGetBookByIsbn() throws Exception {
        Book book = catalogue3.getBookByIsbn(testIsbn1);
        assertNotSame(null, book);
        assertEquals(testIsbn1, book.getIsbn());
    }

    @Before
    public void beforeTestUpdateBookDetails() {
        testBook3 = new Book();
        testIsbn2 = generateIsbn();
        testBook3.setIsbn(testIsbn2);
        testBook3.setSynopsis("Lorem ipsum dolor sit amet");
        testBook3.setTitle("Lorem Ipsum");
        testBook3.setAuthorName("Unknown Latin Guy");

        catalogue4 = new LibraryCatalogue();
        catalogue4.addNewBook(testBook3);
    }

    @Test
    public void testUpdateBookDetails() throws Exception {
        // Create object to be used for update

        Book updateBook = new Book();
        updateBook.setSynopsis("Hapa Kenya Hakuna Matata.");
        updateBook.setTitle("Karibu Kenya");
        updateBook.setAuthorName("Eston Karumbi");

        // Exercise update

        assertTrue(catalogue4.updateBookDetails(testIsbn2, updateBook));

        // Confirm update

        Book changedBook = catalogue4.getBookByIsbn(testIsbn2);
        assertEquals("Hapa Kenya Hakuna Matata.", changedBook.getSynopsis());
        assertEquals("Eston Karumbi", changedBook.getAuthorName());
    }

    @Before
    public void beforeTestDeleteBook() {
        Book deleteBook = new Book();
        testIsbn3 = generateIsbn();
        deleteBook.setIsbn(testIsbn3);

        catalogue5 = new LibraryCatalogue();
        catalogue5.addNewBook(deleteBook);
    }

    @Test
    public void testDeleteBook() throws Exception {
        // Exercise deletion

        assertTrue(catalogue5.deleteBook(testIsbn3));

        // Confirm deletion

        Book confirmBook = catalogue5.getBookByIsbn(testIsbn3);
        assertEquals(null, confirmBook);
    }
}