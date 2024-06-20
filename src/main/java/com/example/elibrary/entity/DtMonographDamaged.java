package com.example.elibrary.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "dt_monograph_damaged")
public class DtMonographDamaged {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "damaged_id")
    private int damaged_id;

    @Column(name = "damaged_mono_id")
    private int damaged_mono_id;

    @Column(name = "damaged_description")
    private String damaged_description;

    @Column(name = "damaged_date")
    private Date damaged_date;

    @Column(name = "last_person")
    private int last_person;

    @Column(name = "damaged_reported_by")
    private int damaged_reported_by;

    @Column(name = "damaged_created_at")
    private Date damaged_created_at;

    public DtMonographDamaged(){}

    public DtMonographDamaged(int damaged_mono_id, String damaged_description, Date damaged_date, int last_person, int damaged_reported_by, Date damaged_created_at) {
        this.damaged_mono_id = damaged_mono_id;
        this.damaged_description = damaged_description;
        this.damaged_date = damaged_date;
        this.last_person = last_person;
        this.damaged_reported_by = damaged_reported_by;
        this.damaged_created_at = damaged_created_at;
    }

    public int getDamaged_id() {
        return damaged_id;
    }

    public void setDamaged_id(int damaged_id) {
        this.damaged_id = damaged_id;
    }

    public int getDamaged_mono_id() {
        return damaged_mono_id;
    }

    public void setDamaged_mono_id(int damaged_mono_id) {
        this.damaged_mono_id = damaged_mono_id;
    }

    public String getDamaged_description() {
        return damaged_description;
    }

    public void setDamaged_description(String damaged_description) {
        this.damaged_description = damaged_description;
    }

    public Date getDamaged_date() {
        return damaged_date;
    }

    public void setDamaged_date(Date damaged_date) {
        this.damaged_date = damaged_date;
    }

    public int getLast_person() {
        return last_person;
    }

    public void setLast_person(int last_person) {
        this.last_person = last_person;
    }

    public int getDamaged_reported_by() {
        return damaged_reported_by;
    }

    public void setDamaged_reported_by(int damaged_reported_by) {
        this.damaged_reported_by = damaged_reported_by;
    }

    public Date getDamaged_created_at() {
        return damaged_created_at;
    }

    public void setDamaged_created_at(Date damaged_created_at) {
        this.damaged_created_at = damaged_created_at;
    }

    @Override
    public String toString() {
        return "DtMonographDamaged{" +
                "damaged_id=" + damaged_id +
                ", damaged_mono_id=" + damaged_mono_id +
                ", damaged_description='" + damaged_description + '\'' +
                ", damaged_date=" + damaged_date +
                ", last_person=" + last_person +
                ", damaged_reported_by=" + damaged_reported_by +
                ", damaged_created_at=" + damaged_created_at +
                '}';
    }
}
