package com.example.elibrary.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "st_user_role")
public class StUserRole {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "user_guid")
    private String user_guid;

    @Column(name = "role_id")
    private int role_id;

    @Column(name = "module_id")
    private int module_id;

    @Column(name = "approved_by")
    private String approved_by;

    @Column(name = "approved_date")
    private Date approved_date;

    @Column(name = "status")
    private int status;

    public StUserRole(){}

    public StUserRole(int id, String user_guid, int role_id, int module_id, String approved_by, Date approved_date, int status) {
        this.id = id;
        this.user_guid = user_guid;
        this.role_id = role_id;
        this.module_id = module_id;
        this.approved_by = approved_by;
        this.approved_date = approved_date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_guid() {
        return user_guid;
    }

    public void setUser_guid(String user_guid) {
        this.user_guid = user_guid;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getModule_id() {
        return module_id;
    }

    public void setModule_id(int module_id) {
        this.module_id = module_id;
    }

    public String getApproved_by() {
        return approved_by;
    }

    public void setApproved_by(String approved_by) {
        this.approved_by = approved_by;
    }

    public Date getApproved_date() {
        return approved_date;
    }

    public void setApproved_date(Date approved_date) {
        this.approved_date = approved_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
