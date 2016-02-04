package com.andela.bookclub.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    // Priivate field to use for testing

    private Book book = new Book();

    @Before
    public void beforeTestGetTitle() {
        book.setTitle("Foo");
    }

    @Test
    public void testGetTitle() throws Exception {
        String bookTitle = book.getTitle();
        assertNotSame(null, bookTitle);
        assertNotSame("", bookTitle);
        assertEquals("Foo", bookTitle);
    }

    @Before
    public void beforeTestGetIsbn() {
        book.setIsbn("1234-5678-9123");
    }

    @Test
    public void testGetIsbn() throws Exception {
        String bookIsbn = book.getIsbn();
        assertNotSame(null, bookIsbn);
        assertNotSame("", bookIsbn);
        assertEquals("1234-5678-9123", bookIsbn);
    }

    @Test
    public void testGetAuthorName() throws Exception {

    }

    @Test
    public void testGetSynopsis() throws Exception {

    }
}