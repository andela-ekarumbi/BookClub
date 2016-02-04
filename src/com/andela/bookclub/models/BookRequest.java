package com.andela.bookclub.models;

import java.util.Date;

public class BookRequest extends Model {

    // Private fields

    private Book book;

    private Member borrower;

    private Date requestDate;

    private boolean isRequestGranted;

    private Date grantedDate;

    private StaffMember granter;

    private Date returnByDate;

    private boolean isBookReturned;

    // Getters and setters


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getBorrower() {
        return borrower;
    }

    public void setBorrower(Member borrower) {
        this.borrower = borrower;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public boolean isRequestGranted() {
        return isRequestGranted;
    }

    public void setRequestGranted(boolean requestGranted) {
        isRequestGranted = requestGranted;
    }

    public Date getGrantedDate() {
        return grantedDate;
    }

    public void setGrantedDate(Date grantedDate) {
        this.grantedDate = grantedDate;
    }

    public StaffMember getGranter() {
        return granter;
    }

    public void setGranter(StaffMember granter) {
        this.granter = granter;
    }

    public Date getReturnByDate() {
        return returnByDate;
    }

    public void setReturnByDate(Date returnByDate) {
        this.returnByDate = returnByDate;
    }

    public boolean isBookReturned() {
        return isBookReturned;
    }

    public void setBookReturned(boolean bookReturned) {
        isBookReturned = bookReturned;
    }
}
