package com.example.elibrary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dt_monograph_isbn_acc")
public class DtMonographIsbnAcc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "isbn_no")
    private String isbn_no;

    @Column(name = "accession_no")
    private String accession_no;

    public DtMonographIsbnAcc(){}

    public DtMonographIsbnAcc(String isbn_no, String accession_no) {
        this.isbn_no = isbn_no;
        this.accession_no = accession_no;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn_no() {
        return isbn_no;
    }

    public void setIsbn_no(String isbn_no) {
        this.isbn_no = isbn_no;
    }

    public String getAccession_no() {
        return accession_no;
    }

    public void setAccession_no(String accession_no) {
        this.accession_no = accession_no;
    }
}
