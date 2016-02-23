package com.andela.bookclub.operations;

import com.andela.bookclub.models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

import static org.junit.Assert.*;

public class LibraryTest {

    private Library libraryPeter;

    private Library libraryJames;

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

    @Before
    public void beforeTestAddBookRequest() {
        bookTreasureIsland = new Book("1209876");
        bookTreasureIsland.setTitle("Treasure Island");

        staffPeter = new StaffMember("staffP");

        studentLuke = new StudentMember("studL");

        request1 = new BookRequest();
        request1.setRequestDate(new Date());
        request1.setBorrower(studentLuke);
    }

    @Test
    public void testAddBookRequest() throws Exception {
        libraryPeter = new Library(staffPeter);
        assertTrue(libraryPeter.addBookRequest(request1));
    }

    @Before
    public void beforeTestLendBooks() {

        bookDavidCopperfield = new Book("987686876");
        bookDavidCopperfield.setTitle("David Copperfield");
        bookHuckFinn = new Book("8758756648");
        bookHuckFinn.setTitle("Huck Finn");
        bookThreeMusketeers = new Book("28376768");
        bookThreeMusketeers.setTitle("Three Musketeers");

        staffMark = new StaffMember("staffM");
        staffPeter = new StaffMember("staff2");
        staffMatthew = new StaffMember("staff3");

        studentSteve = new StudentMember("studentSteve");
        studentPaul = new StudentMember("studentPaul");
        studentEston = new StudentMember("studentEston");
        studentSu = new StudentMember("studentSu");

        staffJames = new StaffMember("staff4");
        libraryJames = new Library(staffJames);

        BookRequest bookRequest1 = new BookRequest();
        bookRequest1.setBorrower(studentSteve);
        bookRequest1.setRequestedBook(bookDavidCopperfield);
        libraryJames.addBookRequest(bookRequest1);

        BookRequest bookRequest2 = new BookRequest();
        bookRequest2.setBorrower(studentPaul);
        bookRequest2.setRequestedBook(bookDavidCopperfield);
        libraryJames.addBookRequest(bookRequest2);

        BookRequest bookRequest3 = new BookRequest();
        bookRequest3.setBorrower(studentEston);
        bookRequest3.setRequestedBook(bookDavidCopperfield);
        libraryJames.addBookRequest(bookRequest3);

        BookRequest bookRequest4 = new BookRequest();
        bookRequest4.setBorrower(studentSu);
        bookRequest4.setRequestedBook(bookDavidCopperfield);
        libraryJames.addBookRequest(bookRequest4);

        BookRequest bookRequest5 = new BookRequest();
        bookRequest5.setBorrower(staffMark);
        bookRequest5.setRequestedBook(bookHuckFinn);
        libraryJames.addBookRequest(bookRequest5);

        BookRequest bookRequest6 = new BookRequest();
        bookRequest6.setBorrower(staffPeter);
        bookRequest6.setRequestedBook(bookHuckFinn);
        libraryJames.addBookRequest(bookRequest6);

        BookRequest bookRequest7 = new BookRequest();
        bookRequest7.setBorrower(staffMatthew);
        bookRequest7.setRequestedBook(bookHuckFinn);
        libraryJames.addBookRequest(bookRequest7);

        BookRequest bookRequest8 = new BookRequest();
        bookRequest8.setBorrower(studentLuke);
        bookRequest8.setRequestedBook(bookThreeMusketeers);
        libraryJames.addBookRequest(bookRequest8);

        BookRequest bookRequest9 = new BookRequest();
        bookRequest9.setBorrower(studentPaul);
        bookRequest9.setRequestedBook(bookThreeMusketeers);
        libraryJames.addBookRequest(bookRequest9);

        BookRequest bookRequest10 = new BookRequest();
        bookRequest10.setBorrower(staffMatthew);
        bookRequest10.setRequestedBook(bookThreeMusketeers);
        libraryJames.addBookRequest(bookRequest10);

        BookRequest bookRequest11 = new BookRequest();
        bookRequest11.setBorrower(studentLuke);
        bookRequest11.setRequestedBook(bookThreeMusketeers);
        libraryJames.addBookRequest(bookRequest11);
    }

    @Test
    public void testLendBooks() throws Exception {

        Map<Book, Member> lentBooks = libraryJames.lendBooks();

        assertNotNull(lentBooks);

        Member book2Recipient = lentBooks.get(bookDavidCopperfield);
        assertEquals(studentSteve.getId(), book2Recipient.getId());

        Member book3Recipient = lentBooks.get(bookHuckFinn);
        assertEquals(staffMark.getId(), book3Recipient.getId());

        Member book4Recipient = lentBooks.get(bookThreeMusketeers);
        assertEquals(staffMatthew.getId(), book4Recipient.getId());

    }
}