package com.example.elibrary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dt_author")
public class DtAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int author_id;

    @Column(name = "author_name")
    private String author_name;

    @Column(name = "publisher_id")
    private int publisher_id;

    @Column(name = "author_telephone")
    private String author_telephone;

    @Column(name = "author_email")
    private String author_email;

    public DtAuthor(){}

    public DtAuthor(String author_name, int publisher_id, String author_telephone, String author_email) {
        this.author_name = author_name;
        this.publisher_id = publisher_id;
        this.author_telephone = author_telephone;
        this.author_email = author_email;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getAuthor_telephone() {
        return author_telephone;
    }

    public void setAuthor_telephone(String author_telephone) {
        this.author_telephone = author_telephone;
    }

    public String getAuthor_email() {
        return author_email;
    }

    public void setAuthor_email(String author_email) {
        this.author_email = author_email;
    }

    @Override
    public String toString() {
        return "DtAuthor{" +
                "author_id=" + author_id +
                ", author_name='" + author_name + '\'' +
                ", publisher_id=" + publisher_id +
                ", author_telephone='" + author_telephone + '\'' +
                ", author_email='" + author_email + '\'' +
                '}';
    }
}
