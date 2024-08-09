package com.example.elibrary.dto;

public class ReservedBook {

    private int reserve_id;
    private int book_id;
    private String book_title;
    private int copy;
    private int user_id;
    private int library_id;
    private String user_name;
    private String date_reserved;
    private String status;
    private String booking_remarks;
    private String accession_no;

    public  ReservedBook(){}

    public ReservedBook(int reserve_id, int book_id, String book_title, int copy, int user_id, int library_id, String user_name, String date_reserved, String status, String booking_remarks, String accession_no) {
        this.reserve_id = reserve_id;
        this.book_id = book_id;
        this.book_title = book_title;
        this.copy = copy;
        this.user_id = user_id;
        this.library_id = library_id;
        this.user_name = user_name;
        this.date_reserved = date_reserved;
        this.status = status;
        this.booking_remarks = booking_remarks;
        this.accession_no = accession_no;
    }

    public String getAccession_no() {
        return accession_no;
    }

    public void setAccession_no(String accession_no) {
        this.accession_no = accession_no;
    }

    public String getBooking_remarks() {
        return booking_remarks;
    }

    public void setBooking_remarks(String booking_remarks) {
        this.booking_remarks = booking_remarks;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    public int getReserve_id() {
        return reserve_id;
    }

    public void setReserve_id(int reserve_id) {
        this.reserve_id = reserve_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getLibrary_id() {
        return library_id;
    }

    public void setLibrary_id(int library_id) {
        this.library_id = library_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getDate_reserved() {
        return date_reserved;
    }

    public void setDate_reserved(String date_reserved) {
        this.date_reserved = date_reserved;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
