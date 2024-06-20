package com.example.elibrary.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "lt_monograph_subject")
public class LtMonographSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private int subject_id;

    @Column(name = "subject_subject")
    private String subject_subject;

    @Column(name = "subject_description")
    private String subject_description;

    @Column(name = "subject_active")
    private int subject_active;

    @Column(name = "subject_created_at")
    private Date subject_created_at;

    @Column(name = "subject_created_by")
    private String subject_created_by;

    public LtMonographSubject(){}

    public LtMonographSubject(String subject_subject, String subject_description, int subject_active, Date subject_created_at, String subject_created_by) {
        this.subject_subject = subject_subject;
        this.subject_description = subject_description;
        this.subject_active = subject_active;
        this.subject_created_at = subject_created_at;
        this.subject_created_by = subject_created_by;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_subject() {
        return subject_subject;
    }

    public void setSubject_subject(String subject_subject) {
        this.subject_subject = subject_subject;
    }

    public String getSubject_description() {
        return subject_description;
    }

    public void setSubject_description(String subject_description) {
        this.subject_description = subject_description;
    }

    public int getSubject_active() {
        return subject_active;
    }

    public void setSubject_active(int subject_active) {
        this.subject_active = subject_active;
    }

    public Date getSubject_created_at() {
        return subject_created_at;
    }

    public void setSubject_created_at(Date subject_created_at) {
        this.subject_created_at = subject_created_at;
    }

    public String getSubject_created_by() {
        return subject_created_by;
    }

    public void setSubject_created_by(String subject_created_by) {
        this.subject_created_by = subject_created_by;
    }

    @Override
    public String toString() {
        return "LtMonographSubject{" +
                "subject_id=" + subject_id +
                ", subject_subject='" + subject_subject + '\'' +
                ", subject_description='" + subject_description + '\'' +
                ", subject_active=" + subject_active +
                ", subject_created_at=" + subject_created_at +
                ", subject_created_by='" + subject_created_by + '\'' +
                '}';
    }
}
