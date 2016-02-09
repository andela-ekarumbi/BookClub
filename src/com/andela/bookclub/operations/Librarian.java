package com.andela.bookclub.operations;

import com.andela.bookclub.models.Book;
import com.andela.bookclub.models.BookRequest;
import com.andela.bookclub.models.Member;
import com.andela.bookclub.models.StaffMember;

import java.util.*;

public class Librarian {

    // Private fields

    private LibraryCatalogue catalogue;

    private Map<Book, Queue<BookRequest>> staffBookQueueMap;

    private Map<Book, Queue<BookRequest>> studentBookQueueMap;

    private StaffMember staffOnDuty;

    private Map<Book, Member> lentBooks;

    // Constructors

    public Librarian(StaffMember staffOnDuty) {
        this.staffOnDuty = staffOnDuty;
        this.staffBookQueueMap = new HashMap<>();
        this.studentBookQueueMap = new HashMap<>();
        this.catalogue = new LibraryCatalogue();
    }

    // Public methods

    public boolean registerNewBook(Book book) {
        return catalogue.addNewBook(book);
    }

    public boolean addBookRequest(BookRequest bookRequest) {
        try {

            // Get member who requested the book

            Member borrower = bookRequest.getBorrower();

            // Check if borrower is a staff member or
            // a student

            if (borrower instanceof StaffMember) {
                // Add the request to the staff members' queue

                return addRequestToQueue(staffBookQueueMap, bookRequest);
            } else {
                // Add the request to the students' queue

                return addRequestToQueue(studentBookQueueMap, bookRequest);
            }
        } catch (Exception exception) {
            return false;
        }
    }

    private boolean addRequestToQueue(Map<Book, Queue<BookRequest>> bookQueueMap, BookRequest bookRequest) {

        // Get the book that has been requested

        Book requestedBook = bookRequest.getRequestedBook();

        // Get the queue for the requested book

        Queue<BookRequest> bookQueue = bookQueueMap.get(requestedBook);

        // If the queue is null, create it, then add the request to the queue

        if (bookQueue == null) {
            bookQueue = new LinkedList<>();
        }

        bookQueue.add(bookRequest);

        // Associate the queue with the requested book

        bookQueueMap.put(requestedBook, bookQueue);

        return true;
    }

    public Map<Book, Member> lendBooks() {
        // Initialize the map of lent books

        lentBooks = new HashMap<>();

        // Iterate through the students and staff request maps and get unique
        // object keys representing the books requested, then add them to the
        // map of lent books as keys, to be given values later

        for (Book book : staffBookQueueMap.keySet()) {
            if (!lentBooks.containsKey(book)) {
                lentBooks.put(book, null);
            }
        }

        for (Book book : studentBookQueueMap.keySet()) {
            if (!lentBooks.containsKey(book)) {
                lentBooks.put(book, null);
            }
        }

        // Iterate over the key set in lentBooks

        for (Book book : lentBooks.keySet()) {

            // Check if the book has been borrowed by a staff member

            if (staffBookQueueMap.containsKey(book)) {
                assignBookToMember(staffBookQueueMap.get(book), book);
            } else if (studentBookQueueMap.containsKey(book)) {
                // Book has been borrowed by a student

                assignBookToMember(studentBookQueueMap.get(book), book);
            }
        }

        return lentBooks;
    }

    private void assignBookToMember(Queue<BookRequest> requests, Book book) {

        if (requests.size() > 0) {
            BookRequest topRequest = requests.remove();
            Member member = topRequest.getBorrower();
            lentBooks.put(book, member);
        }
    }
}
