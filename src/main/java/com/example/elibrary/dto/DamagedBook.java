package com.example.elibrary.dto;

import java.util.Date;

public class DamagedBook {

    private int damaged_id;
    private int book_id;
    private String book_title;
    private int last_person_id;
    private String last_person_name;
    private Date date_return;
    private boolean damaged;
    private String damaged_description;

    public DamagedBook(){}

    public DamagedBook(int damaged_id, int book_id, String book_title, int last_person_id, String last_person_name, Date date_return, boolean damaged, String damaged_description) {
        this.damaged_id = damaged_id;
        this.book_id = book_id;
        this.book_title = book_title;
        this.last_person_id = last_person_id;
        this.last_person_name = last_person_name;
        this.date_return = date_return;
        this.damaged = damaged;
        this.damaged_description = damaged_description;
    }

    public int getDamaged_id() {
        return damaged_id;
    }

    public void setDamaged_id(int damaged_id) {
        this.damaged_id = damaged_id;
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

    public int getLast_person_id() {
        return last_person_id;
    }

    public void setLast_person_id(int last_person_id) {
        this.last_person_id = last_person_id;
    }

    public String getLast_person_name() {
        return last_person_name;
    }

    public void setLast_person_name(String last_person_name) {
        this.last_person_name = last_person_name;
    }

    public Date getDate_return() {
        return date_return;
    }

    public void setDate_return(Date date_return) {
        this.date_return = date_return;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    public String getDamaged_description() {
        return damaged_description;
    }

    public void setDamaged_description(String damaged_description) {
        this.damaged_description = damaged_description;
    }
}
