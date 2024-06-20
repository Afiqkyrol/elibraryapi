package com.example.elibrary.dto;

import java.util.Date;

public class ReservationList {

    private int book_id;
    private String book_title;
    private String copy;
    private int user_id;
    private int library_id;
    private String user_name;
    private String date_reserved;
    private String status;

    public ReservationList(){}

    public ReservationList(int book_id, String book_title, String copy, int user_id, int library_id, String user_name, String date_reserved, String status) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.copy = copy;
        this.user_id = user_id;
        this.library_id = library_id;
        this.user_name = user_name;
        this.date_reserved = date_reserved;
        this.status = status;
    }

    public String getCopy() {
        return copy;
    }

    public void setCopy(String copy) {
        this.copy = copy;
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
