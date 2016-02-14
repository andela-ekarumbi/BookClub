package com.andela.bookclub.operations;

import com.andela.bookclub.models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

import static org.junit.Assert.*;

public class LibrarianTest {

    // Private variables

    private Librarian librarianJohn;

    private Librarian librarianPeter;

    private Librarian librarianJames;

    private StaffMember staffJohn;

    private StaffMember staffPeter;

    private StaffMember staffMatthew;
    
    private StaffMember staffJames;

    private StaffMember staffMark;

    private StudentMember studentLuke;

    private StudentMember studentPaul;

    private StudentMember studentEston;

    private StudentMember studentSu;

    private StudentMember studentSteve;

    private BookRequest request1;

    private Book bookTreasureIsland;

    private Book bookDavidCopperfield;

    private Book bookHuckFinn;

    private Book bookThreeMusketeers;

    // Test methods

    @Before
    public void beforeTestRegisterNewBook() {
        staffJohn = new StaffMember();
        staffJohn.setId("123654");
    }

    @Test
    public void testRegisterNewBook() throws Exception {
        librarianJohn = new Librarian(staffJohn);
        assertTrue(librarianJohn.registerNewBook(new Book()));
    }

    @Before
    public void beforeTestAddBookRequest() {
        bookTreasureIsland = new Book();
        bookTreasureIsland.setTitle("Treasure Island");

        staffPeter = new StaffMember();

        studentLuke = new StudentMember();

        request1 = new BookRequest();
        request1.setRequestDate(new Date());
        request1.setBorrower(studentLuke);
    }

    @Test
    public void testAddBookRequest() throws Exception {
        librarianPeter = new Librarian(staffPeter);
        assertTrue(librarianPeter.addBookRequest(request1));
    }

    @Before
    public void beforeTestLendBooks() {

        bookDavidCopperfield = new Book();
        bookDavidCopperfield.setTitle("David Copperfield");
        bookHuckFinn = new Book();
        bookHuckFinn.setTitle("Huck Finn");
        bookThreeMusketeers = new Book();
        bookThreeMusketeers.setTitle("Three Musketeers");

        staffMark = new StaffMember();
        staffMark.setId("staff5");
        staffPeter = new StaffMember();
        staffPeter.setId("staff2");
        staffMatthew = new StaffMember();
        staffMatthew.setId("staff3");

        studentSteve = new StudentMember();
        studentSteve.setId("studentSteve");
        studentPaul = new StudentMember();
        studentPaul.setId("studentPaul");
        studentEston = new StudentMember();
        studentEston.setId("studentEston");
        studentSu = new StudentMember();
        studentSu.setId("studentSu");

        staffJames = new StaffMember();
        staffJames.setId("staff4");
        librarianJames = new Librarian(staffJames);

        BookRequest bookRequest1 = new BookRequest();
        bookRequest1.setBorrower(studentSteve);
        bookRequest1.setRequestedBook(bookDavidCopperfield);
        librarianJames.addBookRequest(bookRequest1);

        BookRequest bookRequest2 = new BookRequest();
        bookRequest2.setBorrower(studentPaul);
        bookRequest2.setRequestedBook(bookDavidCopperfield);
        librarianJames.addBookRequest(bookRequest2);

        BookRequest bookRequest3 = new BookRequest();
        bookRequest3.setBorrower(studentEston);
        bookRequest3.setRequestedBook(bookDavidCopperfield);
        librarianJames.addBookRequest(bookRequest3);

        BookRequest bookRequest4 = new BookRequest();
        bookRequest4.setBorrower(studentSu);
        bookRequest4.setRequestedBook(bookDavidCopperfield);
        librarianJames.addBookRequest(bookRequest4);

        BookRequest bookRequest5 = new BookRequest();
        bookRequest5.setBorrower(staffMark);
        bookRequest5.setRequestedBook(bookHuckFinn);
        librarianJames.addBookRequest(bookRequest5);

        BookRequest bookRequest6 = new BookRequest();
        bookRequest6.setBorrower(staffPeter);
        bookRequest6.setRequestedBook(bookHuckFinn);
        librarianJames.addBookRequest(bookRequest6);

        BookRequest bookRequest7 = new BookRequest();
        bookRequest7.setBorrower(staffMatthew);
        bookRequest7.setRequestedBook(bookHuckFinn);
        librarianJames.addBookRequest(bookRequest7);

        BookRequest bookRequest8 = new BookRequest();
        bookRequest8.setBorrower(studentLuke);
        bookRequest8.setRequestedBook(bookThreeMusketeers);
        librarianJames.addBookRequest(bookRequest8);

        BookRequest bookRequest9 = new BookRequest();
        bookRequest9.setBorrower(studentPaul);
        bookRequest9.setRequestedBook(bookThreeMusketeers);
        librarianJames.addBookRequest(bookRequest9);

        BookRequest bookRequest10 = new BookRequest();
        bookRequest10.setBorrower(staffMatthew);
        bookRequest10.setRequestedBook(bookThreeMusketeers);
        librarianJames.addBookRequest(bookRequest10);

        BookRequest bookRequest11 = new BookRequest();
        bookRequest11.setBorrower(studentLuke);
        bookRequest11.setRequestedBook(bookThreeMusketeers);
        librarianJames.addBookRequest(bookRequest11);
    }

    @Test
    public void testLendBooks() throws Exception {

        Map<Book, Member> lentBooks = librarianJames.lendBooks();

        assertNotNull(lentBooks);

        Member book2Recipient = lentBooks.get(bookDavidCopperfield);
        assertEquals(studentSteve.getId(), book2Recipient.getId());

        Member book3Recipient = lentBooks.get(bookHuckFinn);
        assertEquals(staffMark.getId(), book3Recipient.getId());

        Member book4Recipient = lentBooks.get(bookThreeMusketeers);
        assertEquals(staffMatthew.getId(), book4Recipient.getId());

    }
}