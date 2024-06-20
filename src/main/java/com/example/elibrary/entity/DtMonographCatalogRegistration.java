package com.example.elibrary.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "dt_monograph_catalog_registration")
public class DtMonographCatalogRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catreg_id")
    private int catreg_id;

    @Column(name = "catreg_mono_reg_id")
    private int catreg_mono_reg_id;

    @Column(name = "catreg_tag")
    private int catreg_tag;

    @Column(name = "catreg_ind1")
    private String catreg_ind1;

    @Column(name = "catreg_ind2")
    private String catreg_ind2;

    @Column(name = "catreg_data")
    private String catreg_data;

    @Column(name = "catreg_created_date")
    private Date catreg_created_date;

    public DtMonographCatalogRegistration(){}

    public DtMonographCatalogRegistration(int catreg_mono_reg_id, int catreg_tag, String catreg_ind1, String catreg_ind2, String catreg_data, Date catreg_created_date) {
        this.catreg_mono_reg_id = catreg_mono_reg_id;
        this.catreg_tag = catreg_tag;
        this.catreg_ind1 = catreg_ind1;
        this.catreg_ind2 = catreg_ind2;
        this.catreg_data = catreg_data;
        this.catreg_created_date = catreg_created_date;
    }

    public int getCatreg_id() {
        return catreg_id;
    }

    public void setCatreg_id(int catreg_id) {
        this.catreg_id = catreg_id;
    }

    public int getCatreg_mono_reg_id() {
        return catreg_mono_reg_id;
    }

    public void setCatreg_mono_reg_id(int catreg_mono_reg_id) {
        this.catreg_mono_reg_id = catreg_mono_reg_id;
    }

    public int getCatreg_tag() {
        return catreg_tag;
    }

    public void setCatreg_tag(int catreg_tag) {
        this.catreg_tag = catreg_tag;
    }

    public String getCatreg_ind1() {
        return catreg_ind1;
    }

    public void setCatreg_ind1(String catreg_ind1) {
        this.catreg_ind1 = catreg_ind1;
    }

    public String getCatreg_ind2() {
        return catreg_ind2;
    }

    public void setCatreg_ind2(String catreg_ind2) {
        this.catreg_ind2 = catreg_ind2;
    }

    public String getCatreg_data() {
        return catreg_data;
    }

    public void setCatreg_data(String catreg_data) {
        this.catreg_data = catreg_data;
    }

    public Date getCatreg_created_date() {
        return catreg_created_date;
    }

    public void setCatreg_created_date(Date catreg_created_date) {
        this.catreg_created_date = catreg_created_date;
    }

    @Override
    public String toString() {
        return "DtMonographCatalogRegistration{" +
                "catreg_id=" + catreg_id +
                ", catreg_mono_reg_id=" + catreg_mono_reg_id +
                ", catreg_tag=" + catreg_tag +
                ", catreg_ind1='" + catreg_ind1 + '\'' +
                ", catreg_ind2='" + catreg_ind2 + '\'' +
                ", catreg_data='" + catreg_data + '\'' +
                ", catreg_created_date=" + catreg_created_date +
                '}';
    }
}
