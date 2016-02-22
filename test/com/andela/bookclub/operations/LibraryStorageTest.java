package com.andela.bookclub.operations;

import com.andela.bookclub.models.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryStorageTest {

    private LibraryStorage<Book> catalogue1;

    private LibraryStorage<Book> catalogue2;

    private LibraryStorage<Book> catalogue3;

    private LibraryStorage<Book> catalogue4;

    private LibraryStorage<Book> catalogue5;

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
        catalogue1 = new LibraryStorage<>();
        bookDavidCopperfield = new Book(generateIsbn());
    }

    @Test
    public void testAddNewBook() throws Exception {
        assertTrue(catalogue1.addNewItem(bookDavidCopperfield));
    }

    @Before
    public void beforeTestGetAllBooks() {
        catalogue2 = new LibraryStorage<>();

        List<Book> newBooks = new ArrayList<>();

        Book bookJava = new Book("3845768");
        Book bookCSharp = new Book("987667576");
        Book bookJavaScript = new Book("9823746");

        newBooks.add(bookCSharp);
        newBooks.add(bookJava);
        newBooks.add(bookJavaScript);

        catalogue2.addItemCollection(newBooks);
    }

    @Test
    public void testGetAllBooks() {
        List<Book> books = catalogue2.getAllItems();
        assertNotNull(books);
        assertEquals(3, books.size());
    }

    @Before
    public void beforeTestGetBookByIsbn() {
        bookTreasureIsland = new Book("287462834");
        bookTreasureIslandIsbn = generateIsbn();
        bookTreasureIsland.setIsbn(bookTreasureIslandIsbn);

        catalogue3 = new LibraryStorage<>();
        catalogue3.addNewItem(bookTreasureIsland);
    }

    @Test
    public void testGetBookByIsbn() throws Exception {
        Book book = catalogue3.getItemByUniqueId("isbn", bookTreasureIslandIsbn);
        assertNotNull(book);
        assertEquals(bookTreasureIslandIsbn, book.getIsbn());
    }

    @Before
    public void beforeTestUpdateBookDetails() {
        bookHuckFinnIsbn = generateIsbn();
        bookHuckFinn = new Book(bookHuckFinnIsbn);
        bookHuckFinn.setSynopsis("Lorem ipsum dolor sit amet");
        bookHuckFinn.setTitle("Lorem Ipsum");
        bookHuckFinn.setAuthorName("Unknown Latin Guy");

        catalogue4 = new LibraryStorage<>();
        catalogue4.addNewItem(bookHuckFinn);
    }

    @Test
    public void testUpdateBookDetails() throws Exception {

        Book updateBook = new Book(bookHuckFinnIsbn);
        updateBook.setSynopsis("Hapa Kenya Hakuna Matata.");
        updateBook.setTitle("Karibu Kenya");
        updateBook.setAuthorName("Eston Karumbi");

        assertTrue(catalogue4.updateItemDetails("isbn", bookHuckFinnIsbn, updateBook));

        Book changedBook = catalogue4.getItemByUniqueId("isbn", bookHuckFinnIsbn);
        assertEquals("Hapa Kenya Hakuna Matata.", changedBook.getSynopsis());
        assertEquals("Eston Karumbi", changedBook.getAuthorName());
    }

    @Before
    public void beforeTestDeleteBook() {
        bookMeinKampfIsbn = generateIsbn();
        bookMeinKampf = new Book(bookMeinKampfIsbn);

        catalogue5 = new LibraryStorage<>();
        catalogue5.addNewItem(bookMeinKampf);
    }

    @Test
    public void testDeleteBook() throws Exception {
        assertTrue(catalogue5.deleteItem("isbn", bookMeinKampfIsbn));

        Book confirmBook = catalogue5.getItemByUniqueId("isbn", bookMeinKampfIsbn);
        assertEquals(null, confirmBook);
    }
}