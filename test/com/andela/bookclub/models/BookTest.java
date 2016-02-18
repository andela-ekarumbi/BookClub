package com.andela.bookclub.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    private Book bookFoo = new Book("938764583");

    @Before
    public void beforeTestGetTitle() {
        bookFoo.setTitle("Foo");
    }

    @Test
    public void testGetTitle() throws Exception {
        String bookTitle = bookFoo.getTitle();
        assertNotSame(null, bookTitle);
        assertNotSame("", bookTitle);
        assertEquals("Foo", bookTitle);
    }

    @Before
    public void beforeTestGetIsbn() {
        bookFoo.setIsbn("1234-5678-9123");
    }

    @Test
    public void testGetIsbn() throws Exception {
        String bookIsbn = bookFoo.getIsbn();
        assertNotSame(null, bookIsbn);
        assertNotSame("", bookIsbn);
        assertEquals("1234-5678-9123", bookIsbn);
    }

    @Before
    public void beforeTestGetAuthorName() {
        bookFoo.setAuthorName("John Doe");
    }

    @Test
    public void testGetAuthorName() throws Exception {
        String bookAuthorName = bookFoo.getAuthorName();
        assertNotSame(null, bookAuthorName);
        assertNotSame("", bookAuthorName);
        assertEquals("John Doe", bookAuthorName);
    }

    @Before
    public void beforeTestGetSynopsis() {
        bookFoo.setSynopsis("Lorem ipsum dolor sit amet");
    }

    @Test
    public void testGetSynopsis() throws Exception {
        String bookSynopsis = bookFoo.getSynopsis();
        assertNotSame(null, bookSynopsis);
        assertNotSame("", bookSynopsis);
        assertEquals("Lorem ipsum dolor sit amet", bookSynopsis);
    }
}