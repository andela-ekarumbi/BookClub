package com.andela.bookclub.operations;

import com.andela.bookclub.models.Book;

import java.util.ArrayList;
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
        return false;
    }

    public List<Book> getAllBooks() {
        return null;
    }

    public Book getBookByIsbn(String isbn) {
        return null;
    }

    public boolean updateBookDetails(String isbn, Book book) {
        return false;
    }

    public boolean deleteBook(String isbn) {
        return false;
    }


}
