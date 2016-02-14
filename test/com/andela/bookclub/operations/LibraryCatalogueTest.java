package com.andela.bookclub.operations;

import com.andela.bookclub.models.Book;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LibraryCatalogueTest {


    private LibraryCatalogue catalogue1;

    private LibraryCatalogue catalogue2;

    private LibraryCatalogue catalogue3;

    private LibraryCatalogue catalogue4;

    private LibraryCatalogue catalogue5;

    private Book bookDavidCopperfield;

    private Book bookTreasureIsland;

    private Book bookMeinKampf;

    private Book bookHuckFinn;

    private String bookTreasureIslandIsbn;

    private String bookHuckFinnIsbn;

    private String bookMeinKampfIsbn;

    private String generateIsbn() {
        double randomId = Math.random() * 10000000;

        return Double.toString(randomId);
    }

    @Before
    public  void beforeTestAddNewBook() {
        catalogue1 = new LibraryCatalogue();
        bookDavidCopperfield = new Book();
        bookDavidCopperfield.setIsbn(generateIsbn());
    }

    @Test
    public void testAddNewBook() throws Exception {
        assertTrue(catalogue1.addNewBook(bookDavidCopperfield));
    }

    @Before
    public void beforeTestGetAllBooks() {
        catalogue2 = new LibraryCatalogue();

        for (int i = 0; i < 5; i++) {
            catalogue2.addNewBook(new Book());
        }

    }

    @Test
    public void testGetAllBooks() {
        List<Book> books = catalogue2.getAllBooks();
        assertNotNull(books);
        assertEquals(5, books.size());
    }

    @Before
    public void beforeTestGetBookByIsbn() {
        bookTreasureIsland = new Book();
        bookTreasureIslandIsbn = generateIsbn();
        bookTreasureIsland.setIsbn(bookTreasureIslandIsbn);

        catalogue3 = new LibraryCatalogue();
        catalogue3.addNewBook(bookTreasureIsland);
    }

    @Test
    public void testGetBookByIsbn() throws Exception {
        Book book = catalogue3.getBookByIsbn(bookTreasureIslandIsbn);
        assertNotNull(book);
        assertEquals(bookTreasureIslandIsbn, book.getIsbn());
    }

    @Before
    public void beforeTestUpdateBookDetails() {
        bookHuckFinn = new Book();
        bookHuckFinnIsbn = generateIsbn();
        bookHuckFinn.setIsbn(bookHuckFinnIsbn);
        bookHuckFinn.setSynopsis("Lorem ipsum dolor sit amet");
        bookHuckFinn.setTitle("Lorem Ipsum");
        bookHuckFinn.setAuthorName("Unknown Latin Guy");

        catalogue4 = new LibraryCatalogue();
        catalogue4.addNewBook(bookHuckFinn);
    }

    @Test
    public void testUpdateBookDetails() throws Exception {

        Book updateBook = new Book();
        updateBook.setSynopsis("Hapa Kenya Hakuna Matata.");
        updateBook.setTitle("Karibu Kenya");
        updateBook.setAuthorName("Eston Karumbi");

        assertTrue(catalogue4.updateBookDetails(bookHuckFinnIsbn, updateBook));

        Book changedBook = catalogue4.getBookByIsbn(bookHuckFinnIsbn);
        assertEquals("Hapa Kenya Hakuna Matata.", changedBook.getSynopsis());
        assertEquals("Eston Karumbi", changedBook.getAuthorName());
    }

    @Before
    public void beforeTestDeleteBook() {
        bookMeinKampf = new Book();
        bookMeinKampfIsbn = generateIsbn();
        bookMeinKampf.setIsbn(bookMeinKampfIsbn);

        catalogue5 = new LibraryCatalogue();
        catalogue5.addNewBook(bookMeinKampf);
    }

    @Test
    public void testDeleteBook() throws Exception {
        assertTrue(catalogue5.deleteBook(bookMeinKampfIsbn));

        Book confirmBook = catalogue5.getBookByIsbn(bookMeinKampfIsbn);
        assertEquals(null, confirmBook);
    }
}