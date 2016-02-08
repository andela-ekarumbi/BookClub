package com.andela.bookclub.operations;

import com.andela.bookclub.models.Book;
import com.andela.bookclub.models.StaffMember;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibrarianTest {

    // Private variables

    private Librarian librarian1;

    private Librarian librarian2;

    private Librarian librarian3;

    private StaffMember staffMember1;

    private StaffMember staffMember2;

    private StaffMember staffMember3;

    // Test methods

    @Before
    public void beforeTestRegisterNewBook() {
        staffMember1 = new StaffMember();
        staffMember1.setId("123654");

        librarian1 = new Librarian(staffMember1);
    }

    @Test
    public void testRegisterNewBook() throws Exception {
        assertTrue(librarian1.registerNewBook(new Book()));
    }

    @Test
    public void testAddBookRequest() throws Exception {

    }

    @Test
    public void testLendBooks() throws Exception {

    }
}