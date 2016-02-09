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
        } else {
            return books.get(foundPosition);
        }
    }
    
    private int searchBookByIsbn(String isbn) {

        Collections.sort(books);

        int start = 0;

        int length = books.size();

        if (length == 0) {
            return  -1;
        }

        if (length == 1) {
            if (books.get(0).getIsbn().equals(isbn)) {
                return 0;
            } else {
                return  -1;
            }
        }

        int end = length - 1;

        while (start <= end) {

            if (books.get(start).getIsbn().equals(isbn)) {
                return start;
            }

            if (books.get(end).getIsbn().equals(isbn)) {
                return end;
            }

            int mid = Math.floorDiv((start + end), 2);

            if (books.get(mid).getIsbn().equals(isbn)) {
                return mid;
            } else {

                if (books.get(mid).getIsbn().compareTo(isbn) < 0) {
                    end = mid - 1;
                    start += 1;
                } else {
                    start = mid + 1;
                    end -= 1;
                }
            }
        }

        return -1;
    }

    /**
     * Updates the details of the book with the given ISBN number, using the
     * object given to hold the incoming values.
     * @param isbn The ISBN number of the book to be updated.
     * @param book The Book object containing the values to be updated.
     * @return true for a successful operation, false otherwise.
     * */

    public boolean updateBookDetails(String isbn, Book book) {

        try {
            Book existingBook = getBookByIsbn(isbn);

            if (existingBook != null) {

                Class bookClass = Book.class;

                Field[] bookFields = bookClass.getDeclaredFields();

                for (Field field: bookFields) {

                    field.setAccessible(true);

                    if (field.get(book) != null) {

                        Object incomingValue = field.get(book);

                        field.set(existingBook, incomingValue);
                    }
                }
                return true;

            } else {
                return false;
            }
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

        if (deleteIndex == -1) {
            return false;
        } else {
            books.remove(deleteIndex);
            return true;
        }
    }


}
