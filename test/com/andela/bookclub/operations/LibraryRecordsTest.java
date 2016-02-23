package com.andela.bookclub.operations;

import com.andela.bookclub.models.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryRecordsTest {

    private LibraryRecords<Book> catalogue1;

    private LibraryRecords<Book> catalogue2;

    private LibraryRecords<Book> catalogue3;

    private LibraryRecords<Book> catalogue4;

    private LibraryRecords<Book> catalogue5;

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
    public  void beforeTestAddNewItem() {
        catalogue1 = new LibraryRecords<>();
        bookDavidCopperfield = new Book(generateIsbn());
    }

    @Test
    public void testAddNewItem() throws Exception {
        assertTrue(catalogue1.addNewItem(bookDavidCopperfield));
    }

    @Before
    public void beforeTestGetAllItems() {
        catalogue2 = new LibraryRecords<>();

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
    public void testGetAllItems() {
        List<Book> books = catalogue2.getAllItems();
        assertNotNull(books);
        assertEquals(3, books.size());
    }

    @Before
    public void beforeTestGetItemByUniqueId() {
        bookTreasureIsland = new Book("287462834");
        bookTreasureIslandIsbn = generateIsbn();
        bookTreasureIsland.setIsbn(bookTreasureIslandIsbn);

        catalogue3 = new LibraryRecords<>();
        catalogue3.addNewItem(bookTreasureIsland);
    }

    @Test
    public void testGetItemByUniqueId() throws Exception {
        Book book = catalogue3.getItemByUniqueProperty("isbn", bookTreasureIslandIsbn);
        assertNotNull(book);
        assertEquals(bookTreasureIslandIsbn, book.getIsbn());
    }

    @Before
    public void beforeTestUpdateItemDetails() {
        bookHuckFinnIsbn = generateIsbn();
        bookHuckFinn = new Book(bookHuckFinnIsbn);
        bookHuckFinn.setSynopsis("Lorem ipsum dolor sit amet");
        bookHuckFinn.setTitle("Lorem Ipsum");
        bookHuckFinn.setAuthorName("Unknown Latin Guy");

        catalogue4 = new LibraryRecords<>();
        catalogue4.addNewItem(bookHuckFinn);
    }

    @Test
    public void testUpdateItemDetails() throws Exception {

        Book updateBook = new Book(bookHuckFinnIsbn);
        updateBook.setSynopsis("Hapa Kenya Hakuna Matata.");
        updateBook.setTitle("Karibu Kenya");
        updateBook.setAuthorName("Eston Karumbi");

        assertTrue(catalogue4.updateItemDetails("isbn", bookHuckFinnIsbn, updateBook));

        Book changedBook = catalogue4.getItemByUniqueProperty("isbn", bookHuckFinnIsbn);
        assertEquals("Hapa Kenya Hakuna Matata.", changedBook.getSynopsis());
        assertEquals("Eston Karumbi", changedBook.getAuthorName());
    }

    @Before
    public void beforeTestDeleteItem() {
        bookMeinKampfIsbn = generateIsbn();
        bookMeinKampf = new Book(bookMeinKampfIsbn);

        catalogue5 = new LibraryRecords<>();
        catalogue5.addNewItem(bookMeinKampf);
    }

    @Test
    public void testDeleteItem() throws Exception {
        assertTrue(catalogue5.deleteItem("isbn", bookMeinKampfIsbn));

        Book confirmBook = catalogue5.getItemByUniqueProperty("isbn", bookMeinKampfIsbn);
        assertEquals(null, confirmBook);
    }
}