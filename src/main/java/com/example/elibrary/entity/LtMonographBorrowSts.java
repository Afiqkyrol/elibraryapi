package com.example.elibrary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lt_monograph_borrow_sts")
public class LtMonographBorrowSts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_sts_id")
    private int borrow_sts_id;

    @Column(name = "borrow_sts_status")
    private String borrow_sts_status;

    @Column(name = "borrow_sts_description")
    private String borrow_sts_description;

    public LtMonographBorrowSts(){}

    public LtMonographBorrowSts(String borrow_sts_status, String borrow_sts_description) {
        this.borrow_sts_status = borrow_sts_status;
        this.borrow_sts_description = borrow_sts_description;
    }

    public int getBorrow_sts_id() {
        return borrow_sts_id;
    }

    public void setBorrow_sts_id(int borrow_sts_id) {
        this.borrow_sts_id = borrow_sts_id;
    }

    public String getBorrow_sts_status() {
        return borrow_sts_status;
    }

    public void setBorrow_sts_status(String borrow_sts_status) {
        this.borrow_sts_status = borrow_sts_status;
    }

    public String getBorrow_sts_description() {
        return borrow_sts_description;
    }

    public void setBorrow_sts_description(String borrow_sts_description) {
        this.borrow_sts_description = borrow_sts_description;
    }

    @Override
    public String toString() {
        return "LtMonographBorrowSts{" +
                "borrow_sts_id=" + borrow_sts_id +
                ", borrow_sts_status='" + borrow_sts_status + '\'' +
                ", borrow_sts_description='" + borrow_sts_description + '\'' +
                '}';
    }
}
