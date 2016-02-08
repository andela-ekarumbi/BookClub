package com.andela.bookclub.operations;

import com.andela.bookclub.models.Book;
import com.andela.bookclub.models.BookRequest;
import com.andela.bookclub.models.StaffMember;
import com.andela.bookclub.models.StudentMember;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class LibrarianTest {

    // Private variables

    private Librarian librarian1;

    private Librarian librarian2;

    private Librarian librarian3;

    private StaffMember staffMember1;

    private StaffMember staffMember2;

    private StaffMember staffMember3;

    private StudentMember student1;

    private StudentMember student2;

    private StudentMember student3;

    private StudentMember student4;

    private BookRequest request1;

    private Book book1;

    private Book book2;

    private Book book3;

    private Book book4;

    // Test methods

    @Before
    public void beforeTestRegisterNewBook() {
        staffMember1 = new StaffMember();
        staffMember1.setId("123654");
    }

    @Test
    public void testRegisterNewBook() throws Exception {
        librarian1 = new Librarian(staffMember1);
        assertTrue(librarian1.registerNewBook(new Book()));
    }

    @Before
    public void beforeTestAddBookRequest() {
        book1 = new Book();
        book1.setTitle("Test book 1");

        staffMember2 = new StaffMember();
        staffMember2.setId("8627687456");

        student1 = new StudentMember();

        request1 = new BookRequest();
        request1.setRequestDate(new Date());
        request1.setBorrower(student1);
    }

    @Test
    public void testAddBookRequest() throws Exception {
        librarian2 = new Librarian(staffMember2);
        assertTrue(librarian2.addBookRequest(request1));
    }

    @Test
    public void testLendBooks() throws Exception {

    }
}