package com.example.elibrary.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "st_user")
public class StUser {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "guid")
    private String guid;

    @Column(name = "username")
    private String username;

    @Column(name = "pid")
    private String pid;

    @Column(name = "password")
    private String password;

    @Column(name = "password_expiry_date")
    private Date password_expiry_date;

    @Column(name = "email")
    private String email;

    @Column(name = "created_date")
    private Date created_date;

    @Column(name = "approved_by")
    private String approved_by;

    @Column(name = "approved_date")
    private Date approved_date;

    @Column(name = "locked")
    private boolean locked;

    @Column(name = "failed_count")
    private int failed_count;

    @Column(name = "lang_id")
    private int lang_id;

    @Column(name = "status")
    private int status;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "is_migration")
    private String is_migration;

    @Column(name = "migration_from")
    private String migration_from;

    public StUser(){}

    public StUser(int id, String guid, String username, String pid, String password, Date password_expiry_date, String email, Date created_date, String approved_by, Date approved_date, boolean locked, int failed_count, int lang_id, int status, String remarks, String is_migration, String migration_from) {
        this.id = id;
        this.guid = guid;
        this.username = username;
        this.pid = pid;
        this.password = password;
        this.password_expiry_date = password_expiry_date;
        this.email = email;
        this.created_date = created_date;
        this.approved_by = approved_by;
        this.approved_date = approved_date;
        this.locked = locked;
        this.failed_count = failed_count;
        this.lang_id = lang_id;
        this.status = status;
        this.remarks = remarks;
        this.is_migration = is_migration;
        this.migration_from = migration_from;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getPassword_expiry_date() {
        return password_expiry_date;
    }

    public void setPassword_expiry_date(Date password_expiry_date) {
        this.password_expiry_date = password_expiry_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
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

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public int getFailed_count() {
        return failed_count;
    }

    public void setFailed_count(int failed_count) {
        this.failed_count = failed_count;
    }

    public int getLang_id() {
        return lang_id;
    }

    public void setLang_id(int lang_id) {
        this.lang_id = lang_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getIs_migration() {
        return is_migration;
    }

    public void setIs_migration(String is_migration) {
        this.is_migration = is_migration;
    }

    public String getMigration_from() {
        return migration_from;
    }

    public void setMigration_from(String migration_from) {
        this.migration_from = migration_from;
    }
}
