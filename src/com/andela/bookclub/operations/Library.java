package com.andela.bookclub.operations;

import com.andela.bookclub.models.Book;
import com.andela.bookclub.models.BookRequest;
import com.andela.bookclub.models.Member;
import com.andela.bookclub.models.StaffMember;

import java.util.*;

public class Library {

    private LibraryStorage<Book> catalogue;

    private LibraryStorage<Member> members;

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
        this.catalogue = new LibraryStorage<>();
        this.members = new LibraryStorage<>();
    }

    /**
     * Registers a new book and returns true for a successful operation,
     * or false otherwise.
     * @param newBook The book to be added
     * @return true if successful, false otherwise
     * */

    public boolean registerNewBook(Book newBook) {
        return catalogue.addNewItem(newBook);
    }

    /**
     * Adds a list of Book objects to the current list of books.
     * @param newBooks the list of books to be added
     * @return true for a successful operation, false otherwise.
     * */

    public boolean registerManyBooks(List<Book> newBooks) {
        return catalogue.addItemCollection(newBooks);
    }

    /**
     * Returns a list of all the books in the catalogue.
     * @return a List object containing all the books in the catalogue.
     * */

    public List<Book> getAllBooks() {
        return catalogue.getAllItems();
    }

    /**
     * Searches the catalogue and returns the book with the given ISBN
     * number.
     * @param isbn The ISBN number to use for searching.
     * @return A Book object if found, null otherwise.
     * */

    public Book getBookByIsbn(String isbn) {
        return catalogue.getItemByUniqueProperty("isbn", isbn);
    }

    /**
     * Updates the details of the book with the given ISBN number, using the
     * object given to hold the incoming values.
     * @param isbn The ISBN number of the book to be updated.
     * @param updatedBook The Book object containing the values to be updated.
     * @return true for a successful operation, false otherwise.
     * */

    public boolean updateBookDetails(String isbn, Book updatedBook) {
        return catalogue.updateItemDetails("isbn", isbn, updatedBook);
    }

    /**
     * Deletes the book with the given ISBN from the catalogue.
     * @param isbn The ISBN number of the book to be deleted
     * @return true for a successful operation, false otherwise.
     * */

    public boolean deleteBook(String isbn) {
        return catalogue.deleteItem("isbn", isbn);
    }

    /**
     * Adds a new member to the members collection
     * @param newMember The member to be added.
     * @return true for a successful operation, false otherwise.
     * */

    public boolean registerNewMember(Member newMember) {
        return members.addNewItem(newMember);
    }

    /**
     * Add a collection of Member objects to the current list.
     * @param newMembers the list of members to add to the current list.
     * @return true for a successful operation, false otherwise.
     * */

    public boolean registerManyMembers(List<Member> newMembers) {
        return members.addItemCollection(newMembers);
    }

    /**
     * Returns a list of all the members in the collection.
     * @return A List object containing all the members in the collection.
     * */

    public List<Member> getAllMembers() {
        return members.getAllItems();
    }

    /**
     * Returns the member with the given id.
     * @param id The id of the member to be retrieved.
     * @return A Member object if found, or null otherwise.
     * */

    public Member getMemberById(String id) {
        return members.getItemByUniqueProperty("id", id);
    }

    /**
     * Updates the member with the given id, using the details in the given object.
     * @param id The id of the member to be updated.
     * @param updatedMember The Member object containing the update details.
     * @return true for a successful operation, false otherwise.
     * */

    public boolean updateMemberDetails(String id, Member updatedMember) {
        return members.updateItemDetails("id", id, updatedMember);
    }

    /**
     * Deletes the member with the given id.
     * @param id The id of the member to be deleted.
     * @return true for a successful operation, false otherwise.
     * */

    public boolean deleteMember(String id) {
        return members.deleteItem("id", id);
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
