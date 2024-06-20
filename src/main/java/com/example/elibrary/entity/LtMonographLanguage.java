package com.example.elibrary.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "lt_monograph_language")
public class LtMonographLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lang_id")
    private int lang_id;

    @Column(name = "lang_type")
    private String lang_type;

    @Column(name = "lang_description")
    private String lang_description;

    @Column(name = "lang_active")
    private int lang_active;

    @Column(name = "lang_created_at")
    private Date lang_created_at;

    @Column(name = "lang_created_by")
    private String lang_created_by;

    public LtMonographLanguage(){}

    public LtMonographLanguage(String lang_type, String lang_description, int lang_active, Date lang_created_at, String lang_created_by) {
        this.lang_type = lang_type;
        this.lang_description = lang_description;
        this.lang_active = lang_active;
        this.lang_created_at = lang_created_at;
        this.lang_created_by = lang_created_by;
    }

    public int getLang_id() {
        return lang_id;
    }

    public void setLang_id(int lang_id) {
        this.lang_id = lang_id;
    }

    public String getLang_type() {
        return lang_type;
    }

    public void setLang_type(String lang_type) {
        this.lang_type = lang_type;
    }

    public String getLang_description() {
        return lang_description;
    }

    public void setLang_description(String lang_description) {
        this.lang_description = lang_description;
    }

    public int getLang_active() {
        return lang_active;
    }

    public void setLang_active(int lang_active) {
        this.lang_active = lang_active;
    }

    public Date getLang_created_at() {
        return lang_created_at;
    }

    public void setLang_created_at(Date lang_created_at) {
        this.lang_created_at = lang_created_at;
    }

    public String getLang_created_by() {
        return lang_created_by;
    }

    public void setLang_created_by(String lang_created_by) {
        this.lang_created_by = lang_created_by;
    }

    @Override
    public String toString() {
        return "LtMonographLanguage{" +
                "lang_id=" + lang_id +
                ", lang_type='" + lang_type + '\'' +
                ", lang_description='" + lang_description + '\'' +
                ", lang_active=" + lang_active +
                ", lang_created_at=" + lang_created_at +
                ", lang_created_by='" + lang_created_by + '\'' +
                '}';
    }
}
