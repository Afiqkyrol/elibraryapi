package com.example.elibrary.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "lt_monograph_type")
public class LtMonographType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private int type_id;

    @Column(name = "type_type")
    private String type_type;

    @Column(name = "type_description")
    private String type_description;

    @Column(name = "type_active")
    private int type_active;

    @Column(name = "type_created_at")
    private Date type_created_at;

    @Column(name = "type_created_by")
    private String type_created_by;

    public LtMonographType(){}

    public LtMonographType(String type_type, String type_description, int type_active, Date type_created_at, String type_created_by) {
        this.type_type = type_type;
        this.type_description = type_description;
        this.type_active = type_active;
        this.type_created_at = type_created_at;
        this.type_created_by = type_created_by;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getType_type() {
        return type_type;
    }

    public void setType_type(String type_type) {
        this.type_type = type_type;
    }

    public String getType_description() {
        return type_description;
    }

    public void setType_description(String type_description) {
        this.type_description = type_description;
    }

    public int getType_active() {
        return type_active;
    }

    public void setType_active(int type_active) {
        this.type_active = type_active;
    }

    public Date getType_created_at() {
        return type_created_at;
    }

    public void setType_created_at(Date type_created_at) {
        this.type_created_at = type_created_at;
    }

    public String getType_created_by() {
        return type_created_by;
    }

    public void setType_created_by(String type_created_by) {
        this.type_created_by = type_created_by;
    }

    @Override
    public String toString() {
        return "LtMonographType{" +
                "type_id=" + type_id +
                ", type_type='" + type_type + '\'' +
                ", type_description='" + type_description + '\'' +
                ", type_active=" + type_active +
                ", type_created_at=" + type_created_at +
                ", type_created_by='" + type_created_by + '\'' +
                '}';
    }
}
