package com.andela.bookclub.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;

public class BookRequestTest {

    private BookRequest bookRequest = new BookRequest();

    private Book treasureIsland = new Book("28745682");

    private Member studentEston;

    private StaffMember staffJames;

    private Date bookRequestedDate = new Date();

    private Date bookRequestGrantedDate;

    private Date bookDueDate;

    @Before
    public void beforeTestGetRequestedBook() {
        treasureIsland.setTitle("Treasure Island");
        bookRequest.setRequestedBook(treasureIsland);
    }

    @Test
    public void testGetRequestedBook() throws Exception {
        Book requestedBook = bookRequest.getRequestedBook();
        assertNotSame(null, requestedBook);
        assertEquals(treasureIsland, requestedBook);
    }

    @Before
    public void beforeTestGetBorrower() {
        studentEston = mock(Member.class, CALLS_REAL_METHODS);
        studentEston.setFirstName("John");
        studentEston.setJoinedDate(new Date());
        bookRequest.setBorrower(studentEston);
    }

    @Test
    public void testGetBorrower() throws Exception {
        Member bookBorrower = bookRequest.getBorrower();
        assertNotSame(null, bookBorrower);
        assertEquals(studentEston, bookBorrower);
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
        bookRequestGrantedDate = new Date();
        bookRequest.setGrantedDate(bookRequestGrantedDate);
    }

    @Test
    public void testGetGrantedDate() throws Exception {
        Date grantedDate = bookRequest.getGrantedDate();
        assertNotSame(null, grantedDate);
        assertEquals(bookRequestGrantedDate, grantedDate);
    }

    @Before
    public void beforeTestGetGranter() {
        staffJames = new StaffMember("staffJ");
        staffJames.setSurname("Kamau");
        bookRequest.setGranter(staffJames);
    }

    @Test
    public void testGetGranter() throws Exception {
        StaffMember requestGranter = bookRequest.getGranter();
        assertNotSame(null, requestGranter);
        assertEquals(staffJames, requestGranter);
    }

    @Before
    public void beforeTestGetReturnByDate() {
        bookDueDate = new Date();
        bookRequest.setReturnByDate(bookDueDate);
    }

    @Test
    public void testGetReturnByDate() throws Exception {
        Date returnByDate = bookRequest.getReturnByDate();
        assertNotSame(null, returnByDate);
        assertEquals(bookDueDate, returnByDate);
    }

    @Before
    public void beforeTestIsBookReturned() {
        bookRequest.setBookReturned(false);
    }

    @Test
    public void testIsBookReturned() throws Exception {
        assertFalse(bookRequest.isBookReturned());
    }
}