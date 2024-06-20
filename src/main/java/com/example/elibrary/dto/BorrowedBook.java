package com.example.elibrary.dto;

import java.util.Date;

public class BorrowedBook {

    private int book_id;
    private int history_id;
    private String book_title;
    private int copy;
    private int borrower_id;
    private String borrower;
    private Date date_borrowed;
    private Date est_date_to_return;
    private Date act_date_return;
    private Date extend_date;
    private String status_extend;
    private String status_book;

    public BorrowedBook(){}

    public BorrowedBook(int book_id, int history_id, String book_title, int copy, int borrower_id, String borrower, Date date_borrowed, Date est_date_to_return, Date act_date_return, Date extend_date, String status_extend, String status_book) {
        this.book_id = book_id;
        this.history_id = history_id;
        this.book_title = book_title;
        this.copy = copy;
        this.borrower_id = borrower_id;
        this.borrower = borrower;
        this.date_borrowed = date_borrowed;
        this.est_date_to_return = est_date_to_return;
        this.act_date_return = act_date_return;
        this.extend_date = extend_date;
        this.status_extend = status_extend;
        this.status_book = status_book;
    }

    public int getBorrower_id() {
        return borrower_id;
    }

    public void setBorrower_id(int borrower_id) {
        this.borrower_id = borrower_id;
    }

    public String getStatus_book() {
        return status_book;
    }

    public void setStatus_book(String status_book) {
        this.status_book = status_book;
    }

    public int getCopy() {
        return copy;
    }
    public void setCopy(int copy) {
        this.copy = copy;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getHistory_id() {
        return history_id;
    }

    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public Date getDate_borrowed() {
        return date_borrowed;
    }

    public void setDate_borrowed(Date date_borrowed) {
        this.date_borrowed = date_borrowed;
    }

    public Date getEst_date_to_return() {
        return est_date_to_return;
    }

    public void setEst_date_to_return(Date est_date_to_return) {
        this.est_date_to_return = est_date_to_return;
    }

    public Date getAct_date_return() {
        return act_date_return;
    }

    public void setAct_date_return(Date act_date_return) {
        this.act_date_return = act_date_return;
    }

    public Date getExtend_date() {
        return extend_date;
    }

    public void setExtend_date(Date extend_date) {
        this.extend_date = extend_date;
    }

    public String getStatus_extend() {
        return status_extend;
    }

    public void setStatus_extend(String status_extend) {
        this.status_extend = status_extend;
    }
}
