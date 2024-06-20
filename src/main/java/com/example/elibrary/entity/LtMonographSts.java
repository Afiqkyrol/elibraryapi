package com.example.elibrary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lt_monograph_sts")
public class LtMonographSts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sts_id")
    private int sts_id;

    @Column(name = "sts_status")
    private String sts_status;

    @Column(name = "sts_description")
    private String sts_description;

    public LtMonographSts(){}

    public LtMonographSts(String sts_status, String sts_description) {
        this.sts_status = sts_status;
        this.sts_description = sts_description;
    }

    public int getSts_id() {
        return sts_id;
    }

    public void setSts_id(int sts_id) {
        this.sts_id = sts_id;
    }

    public String getSts_status() {
        return sts_status;
    }

    public void setSts_status(String sts_status) {
        this.sts_status = sts_status;
    }

    public String getSts_description() {
        return sts_description;
    }

    public void setSts_description(String sts_description) {
        this.sts_description = sts_description;
    }

    @Override
    public String toString() {
        return "LtMonographSts{" +
                "sts_id=" + sts_id +
                ", sts_status='" + sts_status + '\'' +
                ", sts_description='" + sts_description + '\'' +
                '}';
    }
}
