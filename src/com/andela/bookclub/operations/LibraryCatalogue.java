package com.andela.bookclub.operations;

import com.andela.bookclub.models.Book;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryCatalogue {

    // Private fields

    private List<Book> books;

    // Constructors

    public LibraryCatalogue() {
        this.books = new ArrayList<>();
    }

    // Public methods

    public boolean addNewBook(Book book) {
        try {
            return books.add(book);
        } catch (Exception e) {
            return false;
        }
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookByIsbn(String isbn) {
        int foundPosition = searchBookByIsbn(isbn);

        if (foundPosition == -1) {
            return null;
        } else {
            return books.get(foundPosition);
        }
    }
    
    private int searchBookByIsbn(String isbn) {
        // First sort the list list

        Collections.sort(books);

        // Then do a binary search for the member with the given id

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

    public boolean updateBookDetails(String isbn, Book book) {

        // We will (attempt to) use type reflection to detect changes in the
        // incoming object and apply them to the existing object.

        try {
            Book existingBook = getBookByIsbn(isbn);

            // Proceed only if there is a book with the given id

            if (existingBook != null) {

                // Get Class object

                Class bookClass = Book.class;

                // Get array of Field objects for private fields in memberClass

                Field[] bookFields = bookClass.getDeclaredFields();

                // Iterate through field array

                for (Field field: bookFields) {

                    // Make private field acessible

                    field.setAccessible(true);

                    // Proceed only if the value of this field in the incoming
                    // object is not null

                    if (field.get(book) != null) {

                        // Obtain the value of this field in the incoming object

                        Object incomingValue = field.get(book);

                        // Set the value of this field in the existing object to the new
                        // value

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

    public boolean deleteBook(String isbn) {
        return false;
    }


}
