package com.example.elibrary.dto;

import com.example.elibrary.entity.DtMonographRegistration;
import jakarta.persistence.Column;

public class AboutMonograph {

    private int book_id;

    private String call_no;

    private String author;

    private String title;

    private String book_description;

    private String image_name;

    private String book_type;

    private String publisher;

    private String item_number;

    private String status;

    private int copy;

    private String quantity;

    private String accession_no;

    private DtMonographRegistration dtMonographRegistration;

    public AboutMonograph(){}

    public AboutMonograph(int book_id, String call_no, String author, String title, String book_description, String image_name, String book_type, String publisher, String item_number, String status, int copy, String quantity, String accession_no, DtMonographRegistration dtMonographRegistration) {
        this.book_id = book_id;
        this.call_no = call_no;
        this.author = author;
        this.title = title;
        this.book_description = book_description;
        this.image_name = image_name;
        this.book_type = book_type;
        this.publisher = publisher;
        this.item_number = item_number;
        this.status = status;
        this.copy = copy;
        this.quantity = quantity;
        this.accession_no = accession_no;
        this.dtMonographRegistration = dtMonographRegistration;
    }

    public String getAccession_no() {
        return accession_no;
    }

    public void setAccession_no(String accession_no) {
        this.accession_no = accession_no;
    }

    public DtMonographRegistration getDtMonographRegistration() {
        return dtMonographRegistration;
    }

    public void setDtMonographRegistration(DtMonographRegistration dtMonographRegistration) {
        this.dtMonographRegistration = dtMonographRegistration;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public String getBook_description() {
        return book_description;
    }

    public void setBook_description(String book_description) {
        this.book_description = book_description;
    }

    public String getBook_type() {
        return book_type;
    }

    public void setBook_type(String book_type) {
        this.book_type = book_type;
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

    public String getCall_no() {
        return call_no;
    }

    public void setCall_no(String call_no) {
        this.call_no = call_no;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getItem_number() {
        return item_number;
    }

    public void setItem_number(String item_number) {
        this.item_number = item_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
