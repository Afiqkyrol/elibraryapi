package com.example.elibrary.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "dt_monograph_booking")
public class DtMonographBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "booking_mono_id")
    private int bookingMonoId;

    @Column(name = "booking_user_id")
    private int bookingUserId;

    @Column(name = "booking_librarian_id")
    private int bookingLibrarianId;

    @Column(name = "booking_date")
    private Date bookingDate;

    @Column(name = "booking_status")
    private int bookingStatus;

    @Column(name = "booking_created_date")
    private Date bookingCreatedDate;

    @Column(name = "booking_remarks")
    private String bookingRemarks;

    public DtMonographBooking(){}

    public DtMonographBooking(int bookingMonoId, int bookingUserId, int bookingLibrarianId, Date bookingDate, int bookingStatus, Date bookingCreatedDate, String bookingRemarks) {
        this.bookingMonoId = bookingMonoId;
        this.bookingUserId = bookingUserId;
        this.bookingLibrarianId = bookingLibrarianId;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
        this.bookingCreatedDate = bookingCreatedDate;
        this.bookingRemarks = bookingRemarks;
    }

    public String getBookingRemarks() {
        return bookingRemarks;
    }

    public void setBookingRemarks(String bookingRemarks) {
        this.bookingRemarks = bookingRemarks;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getBookingMonoId() {
        return bookingMonoId;
    }

    public void setBookingMonoId(int bookingMonoId) {
        this.bookingMonoId = bookingMonoId;
    }

    public int getBookingUserId() {
        return bookingUserId;
    }

    public void setBookingUserId(int bookingUserId) {
        this.bookingUserId = bookingUserId;
    }

    public int getBookingLibrarianId() {
        return bookingLibrarianId;
    }

    public void setBookingLibrarianId(int bookingLibrarianId) {
        this.bookingLibrarianId = bookingLibrarianId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(int bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Date getBookingCreatedDate() {
        return bookingCreatedDate;
    }

    public void setBookingCreatedDate(Date bookingCreatedDate) {
        this.bookingCreatedDate = bookingCreatedDate;
    }

    @Override
    public String toString() {
        return "DtMonographBooking{" +
                "bookingId=" + bookingId +
                ", bookingMonoId=" + bookingMonoId +
                ", bookingUserId=" + bookingUserId +
                ", bookingLibrarianId=" + bookingLibrarianId +
                ", bookingDate=" + bookingDate +
                ", bookingStatus=" + bookingStatus +
                ", bookingCreatedDate=" + bookingCreatedDate +
                '}';
    }
}


