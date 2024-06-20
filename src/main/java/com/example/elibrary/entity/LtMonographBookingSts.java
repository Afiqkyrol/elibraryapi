package com.example.elibrary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lt_monograph_booking_sts")
public class LtMonographBookingSts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_sts_id")
    private int booking_sts_id;

    @Column(name = "booking_sts_status")
    private String booking_sts_status;

    @Column(name = "booking_sts_description")
    private String booking_sts_description;

    public LtMonographBookingSts(){}

    public LtMonographBookingSts(String booking_sts_status, String booking_sts_description) {
        this.booking_sts_status = booking_sts_status;
        this.booking_sts_description = booking_sts_description;
    }

    public int getBooking_sts_id() {
        return booking_sts_id;
    }

    public void setBooking_sts_id(int booking_sts_id) {
        this.booking_sts_id = booking_sts_id;
    }

    public String getBooking_sts_status() {
        return booking_sts_status;
    }

    public void setBooking_sts_status(String booking_sts_status) {
        this.booking_sts_status = booking_sts_status;
    }

    public String getBooking_sts_description() {
        return booking_sts_description;
    }

    public void setBooking_sts_description(String booking_sts_description) {
        this.booking_sts_description = booking_sts_description;
    }

    @Override
    public String toString() {
        return "LtMonographBookingSts{" +
                "booking_sts_id=" + booking_sts_id +
                ", booking_sts_status='" + booking_sts_status + '\'' +
                ", booking_sts_description='" + booking_sts_description + '\'' +
                '}';
    }
}
