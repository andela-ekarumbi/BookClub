package com.andela.bookclub.operations;

import com.andela.bookclub.models.Book;
import com.andela.bookclub.models.BookRequest;
import com.andela.bookclub.models.Member;
import com.andela.bookclub.models.StaffMember;

import java.util.*;

public class Library {

    private LibraryCatalogue catalogue;

    private Map<Book, Queue<BookRequest>> staffBookQueueMap;

    private Map<Book, Queue<BookRequest>> studentBookQueueMap;

    private StaffMember staffOnDuty;

    private Map<Book, Member> lentBooks;

    /**
     * @param staffOnDuty The staff member on duty
     *
     * */

    public Library(StaffMember staffOnDuty) {
        this.staffOnDuty = staffOnDuty;
        this.staffBookQueueMap = new HashMap<>();
        this.studentBookQueueMap = new HashMap<>();
        this.catalogue = new LibraryCatalogue();
    }

    /**
     * Registers a new book and returns true for a successful operation,
     * or false otherwise.
     * @param book The book to be added
     * @return true if successful, false otherwise
     * */

    public boolean registerNewBook(Book book) {
        return catalogue.addNewBook(book);
    }

    /**
     * Adds a new book request to the request queue, and returns true for a
     * successful operation or false otherwise.
     * @param bookRequest A BookRequest object containing information about the request
     * @return true if successful, false otherwise.
     * */

    public boolean addBookRequest(BookRequest bookRequest) {
        try {
            Member borrower = bookRequest.getBorrower();

            if (borrower instanceof StaffMember) {
                return addRequestToQueue(staffBookQueueMap, bookRequest);
            }
            return addRequestToQueue(studentBookQueueMap, bookRequest);
        } catch (Exception exception) {
            return false;
        }
    }

    private boolean addRequestToQueue(Map<Book, Queue<BookRequest>> bookQueueMap, BookRequest bookRequest) {
        Book requestedBook = bookRequest.getRequestedBook();

        Queue<BookRequest> bookQueue = bookQueueMap.get(requestedBook);

        if (bookQueue == null) {
            bookQueue = new LinkedList<>();
        }

        bookQueue.add(bookRequest);

        bookQueueMap.put(requestedBook, bookQueue);

        return true;
    }

    /**
     * Reviews the currently queued book requests, based on predefined logic,
     * and returns a map of books and the members they have been lent to.
     * @return A map whose keys are books and whose values are the members
     * they've been assigned to.
     * */

    public Map<Book, Member> lendBooks() {

        lentBooks = new HashMap<>();

        addUniqueKeysToMap(lentBooks, staffBookQueueMap);

        addUniqueKeysToMap(lentBooks, studentBookQueueMap);

        decideBookRecipients();

        return lentBooks;
    }

    private void decideBookRecipients() {
        for (Book book : lentBooks.keySet()) {

            if (staffBookQueueMap.containsKey(book)) {
                assignBookToMember(staffBookQueueMap.get(book), book);
            } else if (studentBookQueueMap.containsKey(book)) {
                assignBookToMember(studentBookQueueMap.get(book), book);
            }
        }
    }

    private void addUniqueKeysToMap(Map keysContainer, Map<Book, Queue<BookRequest>> keysSource) {

        for (Book book : keysSource.keySet()) {
            if (!keysContainer.containsKey(book)) {
                keysContainer.put(book, null);
            }
        }
    }

    private void assignBookToMember(Queue<BookRequest> requests, Book book) {

        if (requests.size() > 0) {
            BookRequest topRequest = requests.remove();
            Member member = topRequest.getBorrower();
            lentBooks.put(book, member);
        }
    }
}
