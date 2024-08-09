package com.example.elibrary.dto;

import com.example.elibrary.entity.DtMonographBooking;
import com.example.elibrary.entity.DtMonographHistoryStatus;
import com.example.elibrary.entity.DtMonographRegistration;

public class CopyBookDetails {

    private String accession_no;

    private String status;

    private DtMonographRegistration dtMonographRegistration;

    private DtMonographBooking dtMonographBooking;

    private DtMonographHistoryStatus dtMonographHistoryStatus;

    public CopyBookDetails(){}

    public CopyBookDetails(String accession_no, String status, DtMonographRegistration dtMonographRegistration, DtMonographBooking dtMonographBooking, DtMonographHistoryStatus dtMonographHistoryStatus) {
        this.accession_no = accession_no;
        this.status = status;
        this.dtMonographRegistration = dtMonographRegistration;
        this.dtMonographBooking = dtMonographBooking;
        this.dtMonographHistoryStatus = dtMonographHistoryStatus;
    }

    public DtMonographRegistration getDtMonographRegistration() {
        return dtMonographRegistration;
    }

    public void setDtMonographRegistration(DtMonographRegistration dtMonographRegistration) {
        this.dtMonographRegistration = dtMonographRegistration;
    }

    public String getAccession_no() {
        return accession_no;
    }

    public void setAccession_no(String accession_no) {
        this.accession_no = accession_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DtMonographBooking getDtMonographBooking() {
        return dtMonographBooking;
    }

    public void setDtMonographBooking(DtMonographBooking dtMonographBooking) {
        this.dtMonographBooking = dtMonographBooking;
    }

    public DtMonographHistoryStatus getDtMonographHistoryStatus() {
        return dtMonographHistoryStatus;
    }

    public void setDtMonographHistoryStatus(DtMonographHistoryStatus dtMonographHistoryStatus) {
        this.dtMonographHistoryStatus = dtMonographHistoryStatus;
    }
}
