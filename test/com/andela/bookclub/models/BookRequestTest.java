package com.andela.bookclub.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Calendar;

import static org.junit.Assert.*;

import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;

public class BookRequestTest {

    // Private variables to use during testing

    private BookRequest bookRequest = new BookRequest();

    private Book bookToRequest = new Book();

    private Member member;

    private Date bookRequestedDate = new Date();

    private Date bookRequestGrantedDate;

    private Date bookDueDate;

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

    @Before
    public void beforeTestGetBorrower() {
        member = mock(Member.class, CALLS_REAL_METHODS);
        member.setFirstName("John");
        member.setJoinedDate(new Date());
        bookRequest.setBorrower(member);
    }

    @Test
    public void testGetBorrower() throws Exception {
        Member bookBorrower = bookRequest.getBorrower();
        assertNotSame(null, bookBorrower);
        assertEquals(member, bookBorrower);
    }

    @Before
    public void beforeTestGetRequestDate() {
        bookRequest.setRequestDate(bookRequestedDate);
    }

    @Test
    public void testGetRequestDate() throws Exception {
        Date requestedDate = bookRequest.getRequestDate();
        assertNotSame(null, requestedDate);
        assertEquals(bookRequestedDate, requestedDate);
    }

    @Before
    public void beforeTestIsRequestGranted() {
        bookRequest.setRequestGranted(false);
    }

    @Test
    public void testIsRequestGranted() throws Exception {
        assertFalse(bookRequest.isRequestGranted());
    }

    @Before
    public void beforeTestGetGrantedDate() {

        // Create Calendar object to use for date operations
        Calendar calendar = Calendar.getInstance();

        // Assign a Date object to our calendar
        calendar.setTime(bookRequestedDate);

        // Add 3 days to the calendar time
        calendar.add(Calendar.DAY_OF_MONTH, 3);

        // Retrieve a Date object from the calendar and set
        // it as the day the request is granted.
        bookRequestGrantedDate = calendar.getTime();

        bookRequest.setGrantedDate(bookRequestGrantedDate);
    }

    @Test
    public void testGetGrantedDate() throws Exception {
        Date grantedDate = bookRequest.getGrantedDate();
        assertNotSame(null, grantedDate);
        assertEquals(bookRequestGrantedDate, grantedDate);
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