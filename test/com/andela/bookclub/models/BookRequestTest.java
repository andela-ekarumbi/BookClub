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