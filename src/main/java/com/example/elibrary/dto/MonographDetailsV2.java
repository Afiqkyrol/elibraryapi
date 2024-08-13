package com.example.elibrary.dto;

import com.example.elibrary.entity.DtMonographCatalogRegistration;
import com.example.elibrary.entity.DtMonographRegistration;

import java.util.List;

public class MonographDetailsV2 {

    private String title;

    private String author;

    private String publisher;

    private String call_no;

    private String isbn_no;

    private String type;

    private String accession_no;

    private int copy;

    private List<DtMonographCatalogRegistration> catalog;

    private DtMonographRegistration monograph;

    public MonographDetailsV2(){}

    public MonographDetailsV2(String title, String author, String publisher, String call_no, String isbn_no, String type, String accession_no, int copy, List<DtMonographCatalogRegistration> catalog, DtMonographRegistration monograph) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.call_no = call_no;
        this.isbn_no = isbn_no;
        this.type = type;
        this.accession_no = accession_no;
        this.copy = copy;
        this.catalog = catalog;
        this.monograph = monograph;
    }

    public String getAccession_no() {
        return accession_no;
    }

    public void setAccession_no(String accession_no) {
        this.accession_no = accession_no;
    }

    public String getIsbn_no() {
        return isbn_no;
    }

    public void setIsbn_no(String isbn_no) {
        this.isbn_no = isbn_no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCall_no() {
        return call_no;
    }

    public void setCall_no(String call_no) {
        this.call_no = call_no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    public List<DtMonographCatalogRegistration> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<DtMonographCatalogRegistration> catalog) {
        this.catalog = catalog;
    }

    public DtMonographRegistration getMonograph() {
        return monograph;
    }

    public void setMonograph(DtMonographRegistration monograph) {
        this.monograph = monograph;
    }
}
