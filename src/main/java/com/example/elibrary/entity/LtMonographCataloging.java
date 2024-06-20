package com.example.elibrary.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "lt_monograph_cataloging")
public class LtMonographCataloging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cataloging_id")
    private int cataloging_id;

    @Column(name = "cataloging_tag")
    private int cataloging_tag;

    @Column(name = "cataloging_Ind1")
    private String cataloging_Ind1;

    @Column(name = "cataloging_Ind2")
    private String cataloging_Ind2;

    @Column(name = "cataloging_data")
    private String cataloging_data;

    @Column(name = "cataloging_description")
    private String cataloging_description;

    @Column(name = "cataloging_created_at")
    private Date cataloging_created_at;

    @Column(name = "cataloging_created_by")
    private String cataloging_created_by;

    public LtMonographCataloging(){}

    public LtMonographCataloging(int cataloging_tag, String cataloging_Ind1, String cataloging_Ind2, String cataloging_data, String cataloging_description, Date cataloging_created_at, String cataloging_created_by) {
        this.cataloging_tag = cataloging_tag;
        this.cataloging_Ind1 = cataloging_Ind1;
        this.cataloging_Ind2 = cataloging_Ind2;
        this.cataloging_data = cataloging_data;
        this.cataloging_description = cataloging_description;
        this.cataloging_created_at = cataloging_created_at;
        this.cataloging_created_by = cataloging_created_by;
    }

    public int getCataloging_id() {
        return cataloging_id;
    }

    public void setCataloging_id(int cataloging_id) {
        this.cataloging_id = cataloging_id;
    }

    public int getCataloging_tag() {
        return cataloging_tag;
    }

    public void setCataloging_tag(int cataloging_tag) {
        this.cataloging_tag = cataloging_tag;
    }

    public String getCataloging_Ind1() {
        return cataloging_Ind1;
    }

    public void setCataloging_Ind1(String cataloging_Ind1) {
        this.cataloging_Ind1 = cataloging_Ind1;
    }

    public String getCataloging_Ind2() {
        return cataloging_Ind2;
    }

    public void setCataloging_Ind2(String cataloging_Ind2) {
        this.cataloging_Ind2 = cataloging_Ind2;
    }

    public String getCataloging_data() {
        return cataloging_data;
    }

    public void setCataloging_data(String cataloging_data) {
        this.cataloging_data = cataloging_data;
    }

    public String getCataloging_description() {
        return cataloging_description;
    }

    public void setCataloging_description(String cataloging_description) {
        this.cataloging_description = cataloging_description;
    }

    public Date getCataloging_created_at() {
        return cataloging_created_at;
    }

    public void setCataloging_created_at(Date cataloging_created_at) {
        this.cataloging_created_at = cataloging_created_at;
    }

    public String getCataloging_created_by() {
        return cataloging_created_by;
    }

    public void setCataloging_created_by(String cataloging_created_by) {
        this.cataloging_created_by = cataloging_created_by;
    }

    @Override
    public String toString() {
        return "LtMonographCataloging{" +
                "cataloging_id=" + cataloging_id +
                ", cataloging_tag=" + cataloging_tag +
                ", cataloging_Ind1='" + cataloging_Ind1 + '\'' +
                ", cataloging_Ind2='" + cataloging_Ind2 + '\'' +
                ", cataloging_data='" + cataloging_data + '\'' +
                ", cataloging_description='" + cataloging_description + '\'' +
                ", cataloging_created_at=" + cataloging_created_at +
                ", cataloging_created_by='" + cataloging_created_by + '\'' +
                '}';
    }
}
