package com.andela.bookclub.operations;

import com.andela.bookclub.models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class LibraryTest {

    private Library libraryOfLagos;

    private Library libraryOfNairobi;

    private Library libraryOfKampala;

    private Library libraryOfNakuru;

    private Library libraryOfMombasa;

    private Library libraryOfAbuja;

    private Library libraryOfKisumu;

    private Library libraryOfGhana;

    private Library libraryOfTogo;

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

    private Book bookHeadFirstJava;

    private List<Book> booksToAdd;

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
        libraryOfLagos = new Library(staffPeter);
        assertTrue(libraryOfLagos.addBookRequest(request1));
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
        libraryOfNairobi = new Library(staffJames);

        BookRequest bookRequest1 = new BookRequest();
        bookRequest1.setBorrower(studentSteve);
        bookRequest1.setRequestedBook(bookDavidCopperfield);
        libraryOfNairobi.addBookRequest(bookRequest1);

        BookRequest bookRequest2 = new BookRequest();
        bookRequest2.setBorrower(studentPaul);
        bookRequest2.setRequestedBook(bookDavidCopperfield);
        libraryOfNairobi.addBookRequest(bookRequest2);

        BookRequest bookRequest3 = new BookRequest();
        bookRequest3.setBorrower(studentEston);
        bookRequest3.setRequestedBook(bookDavidCopperfield);
        libraryOfNairobi.addBookRequest(bookRequest3);

        BookRequest bookRequest4 = new BookRequest();
        bookRequest4.setBorrower(studentSu);
        bookRequest4.setRequestedBook(bookDavidCopperfield);
        libraryOfNairobi.addBookRequest(bookRequest4);

        BookRequest bookRequest5 = new BookRequest();
        bookRequest5.setBorrower(staffMark);
        bookRequest5.setRequestedBook(bookHuckFinn);
        libraryOfNairobi.addBookRequest(bookRequest5);

        BookRequest bookRequest6 = new BookRequest();
        bookRequest6.setBorrower(staffPeter);
        bookRequest6.setRequestedBook(bookHuckFinn);
        libraryOfNairobi.addBookRequest(bookRequest6);

        BookRequest bookRequest7 = new BookRequest();
        bookRequest7.setBorrower(staffMatthew);
        bookRequest7.setRequestedBook(bookHuckFinn);
        libraryOfNairobi.addBookRequest(bookRequest7);

        BookRequest bookRequest8 = new BookRequest();
        bookRequest8.setBorrower(studentLuke);
        bookRequest8.setRequestedBook(bookThreeMusketeers);
        libraryOfNairobi.addBookRequest(bookRequest8);

        BookRequest bookRequest9 = new BookRequest();
        bookRequest9.setBorrower(studentPaul);
        bookRequest9.setRequestedBook(bookThreeMusketeers);
        libraryOfNairobi.addBookRequest(bookRequest9);

        BookRequest bookRequest10 = new BookRequest();
        bookRequest10.setBorrower(staffMatthew);
        bookRequest10.setRequestedBook(bookThreeMusketeers);
        libraryOfNairobi.addBookRequest(bookRequest10);

        BookRequest bookRequest11 = new BookRequest();
        bookRequest11.setBorrower(studentLuke);
        bookRequest11.setRequestedBook(bookThreeMusketeers);
        libraryOfNairobi.addBookRequest(bookRequest11);
    }

    @Test
    public void testLendBooks() throws Exception {

        Map<Book, Member> lentBooks = libraryOfNairobi.lendBooks();

        assertNotNull(lentBooks);

        Member book2Recipient = lentBooks.get(bookDavidCopperfield);
        assertEquals(studentSteve.getId(), book2Recipient.getId());

        Member book3Recipient = lentBooks.get(bookHuckFinn);
        assertEquals(staffMark.getId(), book3Recipient.getId());

        Member book4Recipient = lentBooks.get(bookThreeMusketeers);
        assertEquals(staffMatthew.getId(), book4Recipient.getId());

    }

    @Test
    public void testRegisterNewBook() throws Exception {
        libraryOfKampala = new Library(staffJames);
        assertTrue(libraryOfKampala.registerNewBook(bookTreasureIsland));
    }

    @Before
    public void beforeTestGetAllBooks() {
        booksToAdd = new ArrayList<>();
        booksToAdd.add(bookDavidCopperfield);
        booksToAdd.add(bookHuckFinn);
        booksToAdd.add(bookThreeMusketeers);

        libraryOfGhana = new Library(staffMark);
        libraryOfGhana.registerManyBooks(booksToAdd);
    }

    @Test
    public void testGetAllBooks() throws Exception {
        List<Book> books = libraryOfGhana.getAllBooks();
        assertNotNull(books);
        assertEquals(3, books.size());
    }

    @Before
    public void beforeTestGetBookByIsbn() {
        bookHuckFinn = new Book("123654");

        libraryOfTogo = new Library(staffJames);
        libraryOfTogo.registerNewBook(bookHuckFinn);
    }

    @Test
    public void testGetBookByIsbn() throws Exception {
        Book book = libraryOfTogo.getBookByIsbn("123654");
        assertNotNull(book);
    }

    @Before
    public void beforeTestUpdateBookDetails() {
        bookDavidCopperfield = new Book("987654");
        bookDavidCopperfield.setTitle("Forgotten book");
        bookDavidCopperfield.setAuthorName("Me Myself");

        libraryOfKampala = new Library(staffPeter);
        libraryOfKampala.registerNewBook(bookDavidCopperfield);
    }

    @Test
    public void testUpdateBookDetails() throws Exception {
        Book updateBook = new Book("987654");
        updateBook.setAuthorName("Mark Twain");
        updateBook.setTitle("The adventures of Huck Finn");

        assertTrue(libraryOfKampala.updateBookDetails("987654", updateBook));

        Book book = libraryOfKampala.getBookByIsbn("987654");

        assertEquals("The adventures of Huck Finn", book.getTitle());
        assertEquals("Mark Twain", book.getAuthorName());
    }

    @Before
    public void beforeTestDeleteBook() {
        bookHeadFirstJava = new Book("123456");
        bookHeadFirstJava.setTitle("Head First Java");

        libraryOfNakuru = new Library(staffPeter);
        libraryOfNakuru.registerNewBook(bookHeadFirstJava);
    }

    @Test
    public void testDeleteBook() throws Exception {
        assertTrue(libraryOfNakuru.deleteBook("123456"));
        assertEquals(null, libraryOfNakuru.getBookByIsbn("123456"));
    }

    @Test
    public void testRegisterNewMember() throws Exception {
        libraryOfKampala = new Library(staffJames);
        assertTrue(libraryOfKampala.registerNewMember(studentEston));
    }

    @Before
    public void beforeTestGetAllMembers() {
        List<Member> newMembers = new ArrayList<>();
        newMembers.add(studentEston);
        newMembers.add(studentLuke);
        newMembers.add(studentPaul);

        libraryOfLagos = new Library(staffMark);
        libraryOfLagos.registerManyMembers(newMembers);
    }

    @Test
    public void testGetAllMembers() throws Exception {
        List<Member> members = libraryOfLagos.getAllMembers();
        assertNotNull(members);
        assertEquals(3, members.size());
    }

    @Before
    public void beforeTestGetMemberById() {
        studentPaul = new StudentMember("studP");

        libraryOfMombasa = new Library(staffMatthew);
        libraryOfMombasa.registerNewMember(studentPaul);
    }

    @Test
    public void testGetMemberById() throws Exception {
        Member student = libraryOfMombasa.getMemberById("studP");
        assertNotNull(student);
    }

    @Before
    public void beforeTestUpdateMemberDetails() {
        studentLuke = new StudentMember("studL");
        studentLuke.setSchool("Andela");

        libraryOfKisumu = new Library(staffMatthew);
        libraryOfKisumu.registerNewMember(studentLuke);
    }

    @Test
    public void testUpdateMemberDetails() throws Exception {
        StudentMember updateStudent = new StudentMember("studL");
        updateStudent.setSchool("Hard Knocks");

        assertTrue(libraryOfKisumu.updateMemberDetails("studL", updateStudent));

        StudentMember student = (StudentMember)libraryOfKisumu.getMemberById("studL");
        assertEquals("Hard Knocks", student.getSchool());
    }

    @Before
    public void beforeTestDeleteMember() {
        studentSu = new StudentMember("studS");

        libraryOfAbuja = new Library(staffJames);
        libraryOfAbuja.registerNewMember(studentSu);
    }

    @Test
    public void testDeleteMember() throws Exception {
        assertTrue(libraryOfAbuja.deleteMember("studS"));
    }
}