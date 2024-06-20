package com.example.elibrary.entity;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "dt_monograph_history_status")
public class DtMonographHistoryStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private int history_id;

    @Column(name = "history_mono_id")
    private int history_mono_id;

    @Column(name = "history_user_id")
    private int history_user_id;

    @Column(name = "history_librarian_id")
    private int history_librarian_id;

    @Column(name = "history_date_borrow")
    private Date history_date_borrow;

    @Column(name = "history_date_return")
    private Date history_date_return;

    @Column(name = "history_status")
    private int history_status;

    @Column(name = "extend")
    private boolean extend;

    @Column(name = "extend_status")
    private String extend_status;

    @Column(name = "extend_date")
    private Date extend_date;

    @Column(name = "history_late")
    private String history_late;

    @Column(name = "history_actual_rtn_date")
    private Date history_actual_rtn_date;

    @Column(name = "history_created_date")
    private Date history_created_date;

    public DtMonographHistoryStatus(){}

    public DtMonographHistoryStatus(int history_mono_id, int history_user_id, int history_librarian_id, Date history_date_borrow, Date history_date_return, int history_status, boolean extend, String extend_status, Date extend_date, String history_late, Date history_actual_rtn_date, Date history_created_date) {
        this.history_mono_id = history_mono_id;
        this.history_user_id = history_user_id;
        this.history_librarian_id = history_librarian_id;
        this.history_date_borrow = history_date_borrow;
        this.history_date_return = history_date_return;
        this.history_status = history_status;
        this.extend = extend;
        this.extend_status = extend_status;
        this.extend_date = extend_date;
        this.history_late = history_late;
        this.history_actual_rtn_date = history_actual_rtn_date;
        this.history_created_date = history_created_date;
    }

    public int getHistory_id() {
        return history_id;
    }

    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }

    public int getHistory_mono_id() {
        return history_mono_id;
    }

    public void setHistory_mono_id(int history_mono_id) {
        this.history_mono_id = history_mono_id;
    }

    public int getHistory_user_id() {
        return history_user_id;
    }

    public void setHistory_user_id(int history_user_id) {
        this.history_user_id = history_user_id;
    }

    public int getHistory_librarian_id() {
        return history_librarian_id;
    }

    public void setHistory_librarian_id(int history_librarian_id) {
        this.history_librarian_id = history_librarian_id;
    }

    public Date getHistory_date_borrow() {
        return history_date_borrow;
    }

    public void setHistory_date_borrow(Date history_date_borrow) {
        this.history_date_borrow = history_date_borrow;
    }

    public Date getHistory_date_return() {
        return history_date_return;
    }

    public void setHistory_date_return(Date history_date_return) {
        this.history_date_return = history_date_return;
    }

    public int getHistory_status() {
        return history_status;
    }

    public void setHistory_status(int history_status) {
        this.history_status = history_status;
    }

    public boolean getExtend() {
        return extend;
    }

    public void setExtend(boolean extend) {
        this.extend = extend;
    }

    public String getExtend_status() {
        return extend_status;
    }

    public void setExtend_status(String extend_status) {
        this.extend_status = extend_status;
    }

    public Date getExtend_date() {
        return extend_date;
    }

    public void setExtend_date(Date extend_date) {
        this.extend_date = extend_date;
    }

    public String getHistory_late() {
        return history_late;
    }

    public void setHistory_late(String history_late) {
        this.history_late = history_late;
    }

    public Date getHistory_actual_rtn_date() {
        return history_actual_rtn_date;
    }

    public void setHistory_actual_rtn_date(Date history_actual_rtn_date) {
        this.history_actual_rtn_date = history_actual_rtn_date;
    }

    public Date getHistory_created_date() {
        return history_created_date;
    }

    public void setHistory_created_date(Date history_created_date) {
        this.history_created_date = history_created_date;
    }

    @Override
    public String toString() {
        return "DtMonographHistoryStatus{" +
                "history_id=" + history_id +
                ", history_mono_id=" + history_mono_id +
                ", history_user_id=" + history_user_id +
                ", history_librarian_id=" + history_librarian_id +
                ", history_date_borrow=" + history_date_borrow +
                ", history_date_return=" + history_date_return +
                ", history_status=" + history_status +
                ", extend='" + extend + '\'' +
                ", extend_status='" + extend_status + '\'' +
                ", extend_date=" + extend_date +
                ", history_late='" + history_late + '\'' +
                ", history_actual_rtn_date=" + history_actual_rtn_date +
                ", history_created_date=" + history_created_date +
                '}';
    }
}
