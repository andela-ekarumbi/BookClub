package com.andela.bookclub.operations;

import com.andela.bookclub.models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

import static org.junit.Assert.*;

public class LibrarianTest {

    // Private variables

    private Librarian librarian1;

    private Librarian librarian2;

    private Librarian librarian3;

    private StaffMember staffMember1;

    private StaffMember staffMember2;

    private StaffMember staffMember3;
    
    private StaffMember staffMember4;

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

    @Before
    public void beforeTestLendBooks() {

        // Initialize books to be borrowed

        book2 = new Book();
        book2.setTitle("Test book 2");
        book3 = new Book();
        book3.setTitle("Test book 3");
        book4 = new Book();
        book4.setTitle("Test book 4");

        // Initialize borrowers

        staffMember1 = new StaffMember();
        staffMember1.setId("staff1");
        staffMember2 = new StaffMember();
        staffMember2.setId("staff2");
        staffMember3 = new StaffMember();
        staffMember3.setId("staff3");

        student1 = new StudentMember();
        student1.setId("student1");
        student2 = new StudentMember();
        student2.setId("student2");
        student3 = new StudentMember();
        student3.setId("student3");
        student4 = new StudentMember();
        student4.setId("student4");
        
        // Initialize librarian
        
        staffMember4 = new StaffMember();
        staffMember4.setId("staff4");
        librarian3 = new Librarian(staffMember4);
        
        // book2 will be borrowed by students only
        
        BookRequest bookRequest1 = new BookRequest();
        bookRequest1.setBorrower(student1);
        bookRequest1.setRequestedBook(book2);
        librarian3.addBookRequest(bookRequest1);

        BookRequest bookRequest2 = new BookRequest();
        bookRequest2.setBorrower(student2);
        bookRequest2.setRequestedBook(book2);
        librarian3.addBookRequest(bookRequest2);

        BookRequest bookRequest3 = new BookRequest();
        bookRequest3.setBorrower(student3);
        bookRequest3.setRequestedBook(book2);
        librarian3.addBookRequest(bookRequest3);

        BookRequest bookRequest4 = new BookRequest();
        bookRequest4.setBorrower(student4);
        bookRequest4.setRequestedBook(book2);
        librarian3.addBookRequest(bookRequest4);
        
        // book3 will be borrowed by staff members only

        BookRequest bookRequest5 = new BookRequest();
        bookRequest5.setBorrower(staffMember1);
        bookRequest5.setRequestedBook(book3);
        librarian3.addBookRequest(bookRequest5);

        BookRequest bookRequest6 = new BookRequest();
        bookRequest6.setBorrower(staffMember2);
        bookRequest6.setRequestedBook(book3);
        librarian3.addBookRequest(bookRequest6);

        BookRequest bookRequest7 = new BookRequest();
        bookRequest7.setBorrower(staffMember3);
        bookRequest7.setRequestedBook(book3);
        librarian3.addBookRequest(bookRequest7);
        
        // book4 will be borrowed by a mixture of students and staff

        BookRequest bookRequest8 = new BookRequest();
        bookRequest8.setBorrower(student1);
        bookRequest8.setRequestedBook(book4);
        librarian3.addBookRequest(bookRequest8);

        BookRequest bookRequest9 = new BookRequest();
        bookRequest9.setBorrower(student2);
        bookRequest9.setRequestedBook(book4);
        librarian3.addBookRequest(bookRequest9);

        BookRequest bookRequest10 = new BookRequest();
        bookRequest10.setBorrower(staffMember3);
        bookRequest10.setRequestedBook(book4);
        librarian3.addBookRequest(bookRequest10);

        BookRequest bookRequest11 = new BookRequest();
        bookRequest11.setBorrower(student1);
        bookRequest11.setRequestedBook(book4);
        librarian3.addBookRequest(bookRequest11);
    }

    @Test
    public void testLendBooks() throws Exception {

        // Exercise the lending functionality

        Map<Book, Member> lentBooks = librarian3.lendBooks();

        // Confirm the lent books pam is not null

        assertNotNull(lentBooks);

        // book2 should go to student1

        Member book2Recipient = lentBooks.get(book2);
        assertEquals(student1, book2Recipient);

        // book3 should go to staffMember1

        Member book3Recipient = lentBooks.get(book3);
        assertEquals(staffMember1, book3Recipient);

        // book4 should go to staffMember3

        Member book4Recipient = lentBooks.get(book4);
        assertEquals(staffMember3, book4Recipient);

    }
}