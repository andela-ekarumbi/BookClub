package com.andela.bookclub.operations;

import com.andela.bookclub.models.Book;
import com.andela.bookclub.models.BookRequest;
import com.andela.bookclub.models.Member;
import com.andela.bookclub.models.StaffMember;

import java.util.Map;
import java.util.Queue;

public class Librarian {

    // Private fields

    private LibraryCatalogue catalogue;

    private Map<Book, Queue<BookRequest>> bookQueueMap;

    private StaffMember staffOnDuty;

    // Constructors

    public Librarian(StaffMember staffOnDuty) {
        this.staffOnDuty = staffOnDuty;
    }

    // Public methods

    public boolean registerNewBook(Book book) {
        return false;
    }

    public boolean addBookRequest(BookRequest bookRequest) {
        return false;
    }

    public Map<Book, Member> lendBooks() {
        return null;
    }
}
