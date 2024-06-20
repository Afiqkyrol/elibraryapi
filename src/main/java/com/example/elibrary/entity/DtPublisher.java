package com.example.elibrary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dt_publisher")
public class DtPublisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private int publisher_id;

    @Column(name = "publisher_name")
    private String publisher_name;

    @Column(name = "publisher_address1")
    private String publisher_address1;

    @Column(name = "publisher_address2")
    private String publisher_address2;

    @Column(name = "publisher_address3")
    private String publisher_address3;

    @Column(name = "publisher_telephone")
    private String publisher_telephone;

    @Column(name = "publisher_email")
    private String publisher_email;

    public DtPublisher(){}

    public DtPublisher(String publisher_name, String publisher_address1, String publisher_address2, String publisher_address3, String publisher_telephone, String publisher_email) {
        this.publisher_name = publisher_name;
        this.publisher_address1 = publisher_address1;
        this.publisher_address2 = publisher_address2;
        this.publisher_address3 = publisher_address3;
        this.publisher_telephone = publisher_telephone;
        this.publisher_email = publisher_email;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    public String getPublisher_address1() {
        return publisher_address1;
    }

    public void setPublisher_address1(String publisher_address1) {
        this.publisher_address1 = publisher_address1;
    }

    public String getPublisher_address2() {
        return publisher_address2;
    }

    public void setPublisher_address2(String publisher_address2) {
        this.publisher_address2 = publisher_address2;
    }

    public String getPublisher_address3() {
        return publisher_address3;
    }

    public void setPublisher_address3(String publisher_address3) {
        this.publisher_address3 = publisher_address3;
    }

    public String getPublisher_telephone() {
        return publisher_telephone;
    }

    public void setPublisher_telephone(String publisher_telephone) {
        this.publisher_telephone = publisher_telephone;
    }

    public String getPublisher_email() {
        return publisher_email;
    }

    public void setPublisher_email(String publisher_email) {
        this.publisher_email = publisher_email;
    }

    @Override
    public String toString() {
        return "DtPublisher{" +
                "publisher_id=" + publisher_id +
                ", publisher_name='" + publisher_name + '\'' +
                ", publisher_address1='" + publisher_address1 + '\'' +
                ", publisher_address2='" + publisher_address2 + '\'' +
                ", publisher_address3='" + publisher_address3 + '\'' +
                ", publisher_telephone='" + publisher_telephone + '\'' +
                ", publisher_email='" + publisher_email + '\'' +
                '}';
    }
}
