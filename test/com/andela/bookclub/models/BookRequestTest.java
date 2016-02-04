package com.andela.bookclub.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Calendar;

import static org.junit.Assert.*;

public class BookRequestTest {

    // Private variables to use during testing

    private BookRequest bookRequest = new BookRequest();
    private Book bookToRequest = new Book();
    private Calendar calendar;
    private Date bookRequestedDate = new Date();

    @Before
    public void beforeTestGetRequestedBook() {
        bookToRequest.setTitle("Treasure Island");
        bookRequest.setRequestedBook(bookToRequest);
    }

    @Test
    public void testGetRequestedBook() throws Exception {
        Book requestedBook = bookRequest.getRequestedBook();
        assertNotSame(null, requestedBook);
        assertEquals(bookToRequest, requestedBook);
    }

    @Test
    public void testGetBorrower() throws Exception {

    }

    @Test
    public void testGetRequestDate() throws Exception {

    }

    @Test
    public void testIsRequestGranted() throws Exception {

    }

    @Test
    public void testGetGrantedDate() throws Exception {

    }

    @Test
    public void testGetGranter() throws Exception {

    }

    @Test
    public void testGetReturnByDate() throws Exception {

    }

    @Test
    public void testIsBookReturned() throws Exception {

    }
}