package com.andela.bookclub.operations;

import com.andela.bookclub.models.Book;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryCatalogue {

    private List<Book> books;

    public LibraryCatalogue() {
        this.books = new ArrayList<>();
    }

    /**
     * Adds a new book to the catalogue.
     * @param book The book to be added.
     * @return true for a successful operation, or false otherwise.
     * */

    public boolean addNewBook(Book book) {
        try {
            return books.add(book);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addBookCollection(List<Book> books) {
        if (books != null) {
            for (Book book : books) {
                addNewBook(book);
            }
            return true;
        }
        return false;
    }

    /**
     * Returns a list of all the books in the catalogue.
     * @return a List object containing all the books in the catalogue.
     * */

    public List<Book> getAllBooks() {
        return books;
    }

    /**
     * Does a binary search on the catalogue and returns the book with the given ISBN
     * number.
     * @param isbn The ISBN number to use for searching.
     * @return A Book object if found, or null otherwise.
     * */

    public Book getBookByIsbn(String isbn) {
        int foundPosition = searchBookByIsbn(isbn);

        if (foundPosition == -1) {
            return null;
        }
        return books.get(foundPosition);
    }
    
    private int searchBookByIsbn(String isbn) {
        return Utility.searchByPropertyValue(books, "isbn", isbn);
    }

    /**
     * Updates the details of the book with the given ISBN number, using the
     * object given to hold the incoming values.
     * @param isbn The ISBN number of the book to be updated.
     * @param incomingBook The Book object containing the values to be updated.
     * @return true for a successful operation, false otherwise.
     * */

    public boolean updateBookDetails(String isbn, Book incomingBook) {

        try {
            Book existingBook = getBookByIsbn(isbn);

            if (existingBook != null) {
                return Utility.copyFieldsFromObject(existingBook, incomingBook);
            }
            return false;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * Deletes the book with the given ISBN from the catalogue.
     * @param isbn The ISBN number of the book to be deleted
     * @return true for a successful operation, false otherwise.
     * */

    public boolean deleteBook(String isbn) {
        int deleteIndex = searchBookByIsbn(isbn);

        if (deleteIndex != -1) {
            books.remove(deleteIndex);
            return true;
        }
        return false;
    }


}
